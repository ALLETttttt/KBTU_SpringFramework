package kz.kbtu.seminar.service;

import kz.kbtu.seminar.model.IPrintable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PrinterService {
    private final IPrintable printer;

    public void print(String text) {
        printer.print(text);
    }
}
