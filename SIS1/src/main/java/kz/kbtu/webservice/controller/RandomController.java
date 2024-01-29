package kz.kbtu.webservice.controller;

import kz.kbtu.webservice.model.Quote;
import kz.kbtu.webservice.model.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RestController
public class RandomController {

    Value value1 = new Value(1L, "1. Really loving Spring Boot, makes stand alone Spring apps easy.");
    Value value2 = new Value(2L, "2. Really loving Spring Boot, makes stand alone Spring apps easy.");
    Value value3 = new Value(3L, "3. Really loving Spring Boot, makes stand alone Spring apps easy.");
    Value value4 = new Value(4L, "4. Really loving Spring Boot, makes stand alone Spring apps easy.");
    Value value5 = new Value(5L, "5. Really loving Spring Boot, makes stand alone Spring apps easy.");

    ArrayList<Value> arrayList =
            new ArrayList<>(Arrays.asList(
                    value1, value2, value3, value4, value5
            ));

    Random random = new Random();

    @GetMapping("/api/random")
    public Quote randomQuote() {
        return new Quote("Success", arrayList.get(random.nextInt(0, 6)));
    }
}
