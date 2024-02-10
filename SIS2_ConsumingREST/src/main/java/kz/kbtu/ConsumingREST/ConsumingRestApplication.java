package kz.kbtu.ConsumingREST;

import kz.kbtu.ConsumingREST.scopes.Person;
import kz.kbtu.ConsumingREST.test.PizzaController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumingRestApplication {
	private static final String NAME = "John Smith";
	private static final String NAME_OTHER = "Anna Jones";

//	@Test
	public static void main(String[] args) {
//		SpringApplication.run(ConsumingRestApplication.class, args);
		var context = SpringApplication.run(ConsumingRestApplication.class, args);
		PizzaController pizzaController = (PizzaController) context.getBean("pizzaController");
		pizzaController.getPizza();
		System.out.println(pizzaController.getPizza());
//		Person p1 = (Person) context.getBean("personSingleton");
//		Person p2 = (Person) context.getBean("personSingleton");
//
//		p1.setName(NAME);
//		Assert.assertEquals(NAME, p2.getName());
//		System.out.println(p2.getName());



//		Person p3 = (Person) context.getBean("personPrototype");
//		Person p4 = (Person) context.getBean("personPrototype");
//
//		p3.setName(NAME);
//		p4.setName(NAME_OTHER);
//		Assert.assertEquals(NAME, p3.getName());
//		Assert.assertEquals(NAME_OTHER, p4.getName());

//		context.close();
	}

}
