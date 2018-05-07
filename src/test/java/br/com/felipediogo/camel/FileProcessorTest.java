package br.com.felipediogo.camel;

import br.com.felipediogo.business.Report;
import br.com.felipediogo.camel.processors.FileProcessor;
import br.com.felipediogo.converters.ClientConverterImpl;
import br.com.felipediogo.converters.SaleConverterImpl;
import br.com.felipediogo.converters.SellerConverterImpl;
import org.apache.camel.Exchange;
import org.apache.camel.test.junit4.ExchangeTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class FileProcessorTest extends ExchangeTestSupport {
    FileProcessor fileProcessor;

    @Before
    public void setup() {
        fileProcessor = new FileProcessor(new ClientConverterImpl(), new SellerConverterImpl(), new SaleConverterImpl());
    }

    @Test
    public void testFileProcessor() throws Exception {
        Exchange exchange = createExchange();
        exchange.getIn().setBody(getExchangeMessage());
        exchange.setProperty("fileName", "arquivo-mock.dat");
        fileProcessor.process(exchange);
        Report report = exchange.getIn().getBody(Report.class);
        assertThat(report.getSellersCount(), is(equalTo("2")));
        assertThat(report.getClientsCount(), is(equalTo("2")));
        assertThat(report.getMostExpensiveSale(), is(equalTo("2099.5")));
        assertThat(report.getWorstSeller(), is(equalTo("Paulo")));
    }

    private String getExchangeMessage() {
        return "001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç9ç[1-10-200,2-15-2.50,3-20-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo";
    }
}
