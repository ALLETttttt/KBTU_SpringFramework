package kz.kbtu.WebService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class QuoteService {
    @Value("${content}")
    private String content;


    private static final ArrayList<kz.kbtu.WebService.model.Value> arrayList = new ArrayList<>();

    public void init() {
        for (int i = 0; i < 6; i++) {
            arrayList.add(new kz.kbtu.WebService.model.Value((long) i+1, this.content));
        }
    }

    public kz.kbtu.WebService.model.Value getQuote() {
        Random random = new Random();
        return arrayList.get(random.nextInt(6));
    }
}
