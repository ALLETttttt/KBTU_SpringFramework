package kz.kbtu.ConsumingREST;

import kz.kbtu.ConsumingREST.person.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumingRestApplication {
	private static final String NAME = "John Smith";
	private static final String NAME_OTHER = "Anna Jones";

	@Test
	public static void main(String[] args) {

		var context = SpringApplication.run(ConsumingRestApplication.class, args);

		Person p1 = (Person) context.getBean("personSingleton");
		Person p2 = (Person) context.getBean("personSingleton");

		p1.setName(NAME);
		Assert.assertEquals(NAME, p2.getName());


		Person p3 = (Person) context.getBean("personPrototype");
		Person p4 = (Person) context.getBean("personPrototype");

		p3.setName(NAME);
		System.out.println(p3.getName().hashCode());

		p4.setName(NAME);
		System.out.println(p4.getName().hashCode());
//		System.out.println(p4.getName().hashCode());

		context.close();
	}

}
