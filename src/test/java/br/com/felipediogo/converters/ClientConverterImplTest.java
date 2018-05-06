package br.com.felipediogo.converters;

import br.com.felipediogo.models.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1;
import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1Line;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class ClientConverterImplTest {

    private ClientConverter clientConverter;

    @Before
    public void setup() {
        clientConverter = new ClientConverterImpl();
    }

    @Test
    public void testShouldConvertValidClient() {
        Client client = clientConverter.convert(buildClient1Line());
        assertThat(client, is(equalTo(buildClient1())));
        String expected = buildClient1().toString();
        String result = client.toString();
        assertThat(result, is(equalTo(expected)));
    }

}
