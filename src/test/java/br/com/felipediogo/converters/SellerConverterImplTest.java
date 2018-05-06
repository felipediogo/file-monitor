package br.com.felipediogo.converters;

import br.com.felipediogo.models.Seller;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.felipediogo.business.builders.SellerBuilder.buildSeller1;
import static br.com.felipediogo.business.builders.SellerBuilder.buildSeller1Line;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class SellerConverterImplTest {

    private SellerConverter sellerConverter;

    @Before
    public void setup() {
        sellerConverter = new SellerConverterImpl();
    }

    @Test
    public void testShouldConvertValidSeller() {
        Seller seller = sellerConverter.convert(buildSeller1Line());
        assertThat(seller, is(equalTo(buildSeller1())));
        String expected = buildSeller1().toString();
        String result = seller.toString();
        assertThat(result, Matchers.is(Matchers.equalTo(expected)));
    }

}
