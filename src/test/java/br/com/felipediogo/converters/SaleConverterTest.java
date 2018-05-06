package br.com.felipediogo.converters;

import br.com.felipediogo.models.Sale;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static br.com.felipediogo.business.builders.SaleBuilder.buildSale1;
import static br.com.felipediogo.business.builders.SaleBuilder.buildSale1Line;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class SaleConverterTest {
    private SaleConverter saleConverter;

    @Before
    public void setup() {
        saleConverter = new SaleConverter();
    }

    @Test
    public void testShouldConvertValidSeller() {
        Optional<Sale> sale = saleConverter.convertSale(buildSale1Line());
        assertThat(sale, is(equalTo(of(buildSale1()))));
        String expected = of(buildSale1()).get().toString();
        String result = sale.get().toString();
        assertThat(result, Matchers.is(Matchers.equalTo(expected)));
    }

    @Test
    public void testShouldReturnEmptyForFailedSeller() {
        Optional<Sale> sale = saleConverter.convertSale("");
        assertThat(sale, is(equalTo(empty())));
    }
}
