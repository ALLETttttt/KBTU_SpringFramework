package kz.kbtu.seminar.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BWPrinter implements IPrintable {
    @Override
    public void print(String text) {
        log.info(String.format("Black-white text: %s", text));
    }
}
