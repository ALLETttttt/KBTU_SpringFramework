package kz.kbtu.ConsumingREST;

import kz.kbtu.ConsumingREST.person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumingRestApplication {
	private static final String NAME = "John Smith";

	public static void main(String[] args) {

		var context = SpringApplication.run(ConsumingRestApplication.class, args);

		Person p1 = (Person) context.getBean("personSingleton");
		Person p2 = (Person) context.getBean("personSingleton");

		p1.setName(NAME);
		System.out.println(NAME.hashCode());
		System.out.println(p2.getName().hashCode());

		System.out.println();

		context.close();
	}

}
