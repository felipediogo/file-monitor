package br.com.felipediogo.converters;

import br.com.felipediogo.models.Sale;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.felipediogo.business.builders.SaleBuilder.buildSale1;
import static br.com.felipediogo.business.builders.SaleBuilder.buildSale1Line;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class SaleConverterImplTest {
    private SaleConverter saleConverter;

    @Before
    public void setup() {
        saleConverter = new SaleConverterImpl();
    }

    @Test
    public void testShouldConvertValidSeller() {
        Sale sale = saleConverter.convert(buildSale1Line());
        assertThat(sale, is(equalTo(buildSale1())));
        String expected = buildSale1().toString();
        String result = sale.toString();
        assertThat(result, Matchers.is(Matchers.equalTo(expected)));
    }

}
