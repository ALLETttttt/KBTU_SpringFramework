package kz.kbtu.ConsumingREST.foo;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter implements Formatter {

    @Override
    public String format() {
        return "Foo";
    }
}
