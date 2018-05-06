package br.com.felipediogo.converters;

import br.com.felipediogo.models.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1;
import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1Line;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class ClientConverterTest {

    private ClientConverter clientConverter;

    @Before
    public void setup() {
        clientConverter = new ClientConverter();
    }

    @Test
    public void testShouldConvertValidClient() {
        Optional<Client> client = clientConverter.convertClient(buildClient1Line());
        assertThat(client, is(equalTo(of(buildClient1()))));
        String expected = of(buildClient1()).get().toString();
        String result = client.get().toString();
        assertThat(result, is(equalTo(expected)));
    }

    @Test
    public void testShouldReturnEmptyForFailedClient() {
        Optional<Client> client = clientConverter.convertClient("");
        assertThat(client, is(equalTo(empty())));
    }
}
