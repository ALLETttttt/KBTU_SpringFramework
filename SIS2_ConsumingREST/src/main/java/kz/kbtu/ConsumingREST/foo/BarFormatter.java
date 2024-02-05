package kz.kbtu.ConsumingREST.foo;

import org.springframework.stereotype.Component;

@Component("barFormatter")
public class BarFormatter implements Formatter {
    @Override
    public String format() {
        return "bar";
    }
}
