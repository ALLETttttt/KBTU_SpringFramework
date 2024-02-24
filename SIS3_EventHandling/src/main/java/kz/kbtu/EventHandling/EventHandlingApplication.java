package kz.kbtu.EventHandling;

import kz.kbtu.EventHandling.listener.SpringBuiltInEventsListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventHandlingApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EventHandlingApplication.class, args);

		SpringApplication application = new SpringApplication(EventHandlingApplication.class);
		application.addListeners(new SpringBuiltInEventsListener());
		application.run(args);
	}

}
