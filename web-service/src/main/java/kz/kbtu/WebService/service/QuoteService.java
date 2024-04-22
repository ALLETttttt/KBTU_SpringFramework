package kz.kbtu.WebService.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuoteService {

    @Value("${content}")
    private String content;


    private static final ArrayList<kz.kbtu.WebService.model.Value> arrayList =
            new ArrayList<>();

    public void init() {
        for (int i = 0; i < 6; i++) {
            log.info("content is: {}", content);
            arrayList.add(new kz.kbtu.WebService.model.Value((long) i+1, this.content));
        }
    }

    public kz.kbtu.WebService.model.Value getQuote() {
        Random random = new Random();
        return arrayList.get(random.nextInt(6));
    }
}
