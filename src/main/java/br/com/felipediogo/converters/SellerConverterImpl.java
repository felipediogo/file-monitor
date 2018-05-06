package br.com.felipediogo.converters;

import br.com.felipediogo.models.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class SellerConverterImpl implements SellerConverter {
    private static final int CPF_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int SALARY_INDEX = 3;
    private static final String SPLITTER = "ç";

    public Seller convert(String line) {
        return new Seller(
                lineValue(line, CPF_INDEX),
                lineValue(line, NAME_INDEX),
                Double.valueOf(lineValue(line, SALARY_INDEX)));
    }

    private String lineValue(String line, int index) {
        return line.split(SPLITTER)[index];
    }
}
