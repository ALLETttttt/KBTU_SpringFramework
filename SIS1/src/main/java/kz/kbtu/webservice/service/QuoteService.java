package kz.kbtu.webservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class QuoteService {
    @Value("${content}")
    private static String content;

    private static final ArrayList<kz.kbtu.webservice.model.Value> arrayList = new ArrayList<>();

    public void init() {
        for (int i = 0; i < 6; i++) {
            arrayList.add(new kz.kbtu.webservice.model.Value((long) i, content));
        }
    }

    public kz.kbtu.webservice.model.Value getQuote() {
        Random random = new Random();
        return arrayList.get(random.nextInt(6));
    }
}
