package br.com.felipediogo.data.salesmen;

import br.com.felipediogo.data.BaseClass;
import br.com.felipediogo.data.LineConverter;
import org.springframework.stereotype.Component;

@Component
public class SalesmanConverter implements LineConverter {
    @Override
    public BaseClass convert(String content) {
        return new BaseClass();
    }
}
