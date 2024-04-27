package orderdb;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

public class OrderDbSimulation extends Simulation {
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
            .baseUrl("http://localhost:1010")
            .acceptHeader("application/json");

    // HTTP Calls
    private static ChainBuilder getAllOrders =
            exec(http("Get All Orders")
                    .get("/orders"));

    private static ChainBuilder getOrderDetail =
            exec(http("Get Order Detail")
                    .get("/orders/detail?orderNumber=0c70c0c2"));

    // Scenario definition
    private ScenarioBuilder scenarioBuilder = scenario("Testing orders")
            .exec(getAllOrders)
            .pause(2)
            .exec(getOrderDetail);

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
