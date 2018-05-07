package br.com.felipediogo.camel;

import br.com.felipediogo.business.Report;
import br.com.felipediogo.camel.processors.ReportProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.test.junit4.ExchangeTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static br.com.felipediogo.business.builders.ClientBuilder.buildClient1;
import static br.com.felipediogo.business.builders.SaleBuilder.buildSale1;
import static br.com.felipediogo.business.builders.SellerBuilder.buildSeller1;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class ReportProcessorTest extends ExchangeTestSupport {
    ReportProcessor reportProcessor;

    @Before
    public void setup() {
        reportProcessor = new ReportProcessor();
    }

    @Test
    public void testShouldCreateReport() {
        Report report = new Report("mock_file_name");
        report.addSale(buildSale1());
        report.addSeller(buildSeller1());
        report.addClient(buildClient1());

        Exchange exchange = createExchange();
        exchange.getIn().setBody(report);
        reportProcessor.process(exchange);
        String reportOutput = exchange.getIn().getBody(String.class);
        assertThat(reportOutput, is(equalTo(expectedOutput())));
    }

    private String expectedOutput() {
        return "Quantidade de clientes no arquivo de entrada: 1\n" +
                "Quantidade de vendedores no arquivo de entrada: 1\n" +
                "Maior venda no arquivo de entrada: 13.3\n" +
                "O pior vendedor no arquivo de entrada: Fulano da Silva Jr.";
    }
}
