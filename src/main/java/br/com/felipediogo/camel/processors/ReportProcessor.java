package br.com.felipediogo.camel.processors;

import br.com.felipediogo.business.Report;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReportProcessor implements Processor {
    static Logger LOG = LoggerFactory.getLogger(ReportProcessor.class);

    @Override
    public void process(Exchange exchange) {
        Report report = exchange.getIn().getBody(Report.class);
        String outputContent = processReport(report);
        LOG.info(outputContent);
        exchange.getIn().setBody(outputContent);
        exchange.setProperty("fileName", report.getFileName());
    }

    private String processReport(Report report) {
        StringBuilder outContent = new StringBuilder();
        outContent.append(String.format("Quantidade de clientes no arquivo de entrada: %s\n",
                report.getClientsCount()));
        outContent.append(String.format("Quantidade de vendedores no arquivo de entrada: %s\n",
                report.getSellersCount()));
        outContent.append(String.format("Maior venda no arquivo de entrada: %s\n",
                report.getMostExpensiveSale()));
        outContent.append(String.format("O pior vendedor no arquivo de entrada: %s",
                report.getWorstSeller()));
        System.out.println(outContent.toString());
        return outContent.toString();
    }

}
