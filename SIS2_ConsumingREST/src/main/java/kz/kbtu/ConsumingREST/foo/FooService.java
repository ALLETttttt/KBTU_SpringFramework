package kz.kbtu.ConsumingREST.foo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class FooService {
    private FooFormatter fooFormatter;

    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter1;

    @Autowired
    @Qualifier("barFormatter")
    private Formatter formatter2;


    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }

    @Autowired
    public void setFooFormatter(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
