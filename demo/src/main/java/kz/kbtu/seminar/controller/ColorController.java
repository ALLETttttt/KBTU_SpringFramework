package kz.kbtu.seminar.controller;

import kz.kbtu.seminar.service.PrinterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ColorController {
    private final PrinterService printerService;

    @GetMapping("/print")
    public String print(@RequestParam(value = "text", defaultValue = "World") String text) {
        printerService.print(text);
        return text;
    }
}
