package br.com.felipediogo.converters;

import br.com.felipediogo.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {
    private static final int CNPJ_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int BUSINESS_INDEX = 3;
    private static final String SPLITTER = "ç";

    public Client convertClient(String line) {
        return new Client(
                lineValue(line, CNPJ_INDEX),
                lineValue(line, NAME_INDEX),
                lineValue(line, BUSINESS_INDEX));
    }

    private String lineValue(String line, int index) {
        return line.split(SPLITTER)[index];
    }
}
