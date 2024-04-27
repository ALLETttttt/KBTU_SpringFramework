package addressdb;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class AddressDbSimulation extends Simulation {
    private static final int USER_COUNT = Integer.parseInt(
            System.getProperty("USERS", "10")
    );
    private static final int RAMP_DURATION = Integer.parseInt(
            System.getProperty("RAMP_DURATION", "15")
    );

    @Override
    public void before() {
        System.out.printf("Running test with %d users%n", USER_COUNT);
        System.out.printf("Ramping users with %d seconds%n", RAMP_DURATION);
    }

    // http configuration
    private HttpProtocolBuilder httpProtocolBuilder = http
            .baseUrl("http://localhost:9090")
            .acceptHeader("application/json");

    // HTTP Calls
    private static ChainBuilder getAllAddresses =
            exec(http("Get All Addresses")
                    .get("/addresses"));

    private static ChainBuilder getAddressByPostalCode =
            exec(http("Get Address by postal code")
                    .get("/addresses/1000001"));

    // Scenario definition
    private ScenarioBuilder scenarioBuilder = scenario("Testing addresses")
            .exec(getAllAddresses)
            .pause(2)
            .exec(getAddressByPostalCode);

    // Load Simulation
    {
        setUp(
                scenarioBuilder.injectOpen(
                        nothingFor(5),
                        rampUsers(USER_COUNT)
                                .during(RAMP_DURATION)


                )
        ).protocols(httpProtocolBuilder);
    }
}
