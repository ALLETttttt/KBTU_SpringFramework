package kz.kbtu.webservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class QuoteService {

    @Value("${value}")
    private String value;

    ArrayList<kz.kbtu.webservice.model.Value> arrayList = new ArrayList<>();

    public void init() {
        for (long i = 1L; i < 6L; i++) {
            arrayList.add(new kz.kbtu.webservice.model.Value(i, value));
        }
    }

    public kz.kbtu.webservice.model.Value getQuote() {
        Random random = new Random();
        return arrayList.get(random.nextInt(6));
    }
}
