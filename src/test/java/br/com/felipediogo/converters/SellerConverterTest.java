package br.com.felipediogo.converters;

import br.com.felipediogo.models.Seller;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static br.com.felipediogo.business.builders.SellerBuilder.buildSeller1;
import static br.com.felipediogo.business.builders.SellerBuilder.buildSeller1Line;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class SellerConverterTest {

    private SellerConverter sellerConverter;

    @Before
    public void setup() {
        sellerConverter = new SellerConverter();
    }

    @Test
    public void testShouldConvertValidSeller() {
        Optional<Seller> seller = sellerConverter.convertSeller(buildSeller1Line());
        assertThat(seller, is(equalTo(of(buildSeller1()))));
        String expected = of(buildSeller1()).get().toString();
        String result = seller.get().toString();
        assertThat(result, Matchers.is(Matchers.equalTo(expected)));
    }

    @Test
    public void testShouldReturnEmptyForFailedSeller() {
        Optional<Seller> seller = sellerConverter.convertSeller("");
        assertThat(seller, is(equalTo(empty())));
    }
}
