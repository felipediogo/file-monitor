package br.com.felipediogo.camel.processors;

import br.com.felipediogo.data.LineConverter;
import br.com.felipediogo.data.clients.ClientConverter;
import br.com.felipediogo.data.sales.SaleConverter;
import br.com.felipediogo.data.salesmen.SalesmanConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FileProcessor {
    @Autowired
    SalesmanConverter salesmanConverter;
    @Autowired
    SaleConverter saleConverter;
    @Autowired
    ClientConverter clientConverter;

    public void process(String content) {

    }

    Map<String, LineConverter> converters = new HashMap<String, LineConverter>() {
        {
            put("001", saleConverter);
            put("002", salesmanConverter);
            put("003", clientConverter);
        }
    };
}
