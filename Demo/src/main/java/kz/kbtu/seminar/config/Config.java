package kz.kbtu.seminar.config;


import kz.kbtu.seminar.model.ColorPrinter;
import kz.kbtu.seminar.model.IPrintable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Config {
    @Value("${server.port}")
    private String port;

    IPrintable getPrinter() {
        if (port.contains("8080"))
            return new ColorPrinter();
        return  null;
    }

}

