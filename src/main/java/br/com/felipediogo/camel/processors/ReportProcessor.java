package br.com.felipediogo.camel.processors;

import br.com.felipediogo.models.Client;
import br.com.felipediogo.models.Report;
import br.com.felipediogo.models.Sale;
import br.com.felipediogo.models.Seller;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

@Component
public class ReportProcessor implements Processor {
    static Logger LOG = LoggerFactory.getLogger(ReportProcessor.class);

    @Override
    public void process(Exchange exchange) {
        Report report = exchange.getIn().getBody(Report.class);
        String outputContent = processReport(report);
        LOG.info(outputContent);
        exchange.getIn().setBody(outputContent);
    }

    private String processReport(Report report) {
        StringBuilder outContent = new StringBuilder();
        outContent.append(String.format("Quantidade de clientes no arquivo de entrada: %s\n",
                getClientsCount(report.getClients())));
        outContent.append(String.format("Quantidade de vendedores no arquivo de entrada: %s\n",
                getSellersCount(report.getSellers())));
        outContent.append(String.format("Maior venda no arquivo de entrada: %s\n",
                getMostExpensiveSale(report.getSales())));
        outContent.append(String.format("O pior vendedor no arquivo de entrada: %s\n",
                getWorstSeller(report.getSales())));
        return outContent.toString();
    }

    private String getMostExpensiveSale(List<Sale> sales) {
        return sales.stream().map(Sale::getSaleValue)
                .reduce((aDouble, aDouble2)
                        -> aDouble > aDouble2 ? aDouble : aDouble2)
                .orElse(0.0).toString();
    }

    private String getClientsCount(List<Client> clients) {
        return String.valueOf(clients.stream().collect(groupingBy(Client::getCnpj)).size());
    }

    private String getSellersCount(List<Seller> sellers) {
        return String.valueOf(sellers.stream().collect(groupingBy(Seller::getCpf)).size());
    }

    private String getWorstSeller(List<Sale> sales) {
        Map<String, Double> groupedInformation =
                sales.stream().collect(groupingBy(Sale::getSellerName, summingDouble(Sale::getSaleValue)));
        WorstSeller worstSeller = new WorstSeller();
        groupedInformation.forEach((a, b) -> {
            if (worstSeller.getValue() == null) {
                worstSeller.setValue(b);
                worstSeller.setName(a);
            } else if (b < worstSeller.getValue()) {
                worstSeller.setValue(b);
                worstSeller.setName(a);
            }
        });

        return worstSeller.getName();
    }

    private class WorstSeller {
        private String name;
        private Double value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }
    }
}
