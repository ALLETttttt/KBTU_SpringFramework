package kz.kbtu.ConsumingREST.scopes;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class HelloMessageGenerator {
    private String message;

    public HelloMessageGenerator() {
        log.info("HelloMessageGenerator");
    }
}
