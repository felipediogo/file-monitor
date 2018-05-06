package br.com.felipediogo.converters;

import br.com.felipediogo.models.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SaleConverterImpl implements SaleConverter {
    private static final int ID_INDEX = 1;
    private static final int SALES_INDEX = 2;
    private static final int SELLER_INDEX = 3;
    private static final int QUANTITY_INDEX = 1;
    private static final int VALUE_INDEX = 2;

    private static final String SPLITTER = "ç";
    private static final String VALUE_SPLITTER = "-";
    private static final String ITEMS_SPLITTER = ",";

    public Sale convert(String line) {
        return new Sale(
                Integer.valueOf(lineValue(line, ID_INDEX)),
                calculateSaleValue(lineValue(line, SALES_INDEX)),
                lineValue(line, SELLER_INDEX));
    }

    private String lineValue(String line, int index) {
        return line.split(SPLITTER)[index];
    }

    private Double calculateSaleValue(String line) {
        String[] items = transformItemsStringToArray(line);
        return Arrays.stream(items)
                .map(s -> doubleValue(s, QUANTITY_INDEX) * doubleValue(s, VALUE_INDEX))
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2)
                .orElse(0.0);
    }

    private Double doubleValue(String line, int index) {
        return Double.valueOf(line.split(VALUE_SPLITTER)[index]);
    }

    private String[] transformItemsStringToArray(String line) {
        return line.substring(1, line.length() - 1).split(ITEMS_SPLITTER);
    }

}
