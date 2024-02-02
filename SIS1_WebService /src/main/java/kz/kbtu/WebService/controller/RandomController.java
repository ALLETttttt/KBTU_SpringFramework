package kz.kbtu.WebService.controller;

import kz.kbtu.WebService.model.Quote;
import kz.kbtu.WebService.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RandomController {
    QuoteService quoteService = new QuoteService();

    @GetMapping("/api/random")
    public Quote randomQuote() {
        return new Quote("Success", quoteService.getQuote());
    }
}
