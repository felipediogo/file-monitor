package br.com.felipediogo.camel.processors;

import br.com.felipediogo.converters.ClientConverter;
import br.com.felipediogo.converters.SaleConverter;
import br.com.felipediogo.converters.SellerConverter;
import br.com.felipediogo.models.Client;
import br.com.felipediogo.models.Report;
import br.com.felipediogo.models.Sale;
import br.com.felipediogo.models.Seller;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFileMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor implements Processor {

    private static final String CLIENT_IDENTIFIER = "002";
    private static final String SELLER_IDENTIFIER = "001";
    private static final String SALE_IDENTIFIER = "003";

    static Logger LOG = LoggerFactory.getLogger(ReportProcessor.class);

    @Autowired
    ClientConverter clientConverter;
    @Autowired
    SellerConverter sellerConverter;
    @Autowired
    SaleConverter saleConverter;

    @Override
    public void process(Exchange exchange) {
        LOG.info("Starting to process file => [{}]", getFileName(exchange));
        String content = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody(createDataForReport(getFileName(exchange), content));
    }

    private Report createDataForReport(String fileName, String content) {
        Report report = new Report(fileName);
        String[] lines = content.split("\n");
        for (String line : lines) {
            LOG.debug("Parsing => [{}]", line);
            switch (lineIdentifier(line)) {
                case CLIENT_IDENTIFIER:
                    Client client = clientConverter.convertClient(line);
                    report.addClient(client);
                    debugLog(client);
                    break;
                case SELLER_IDENTIFIER:
                    Seller seller = sellerConverter.convertSeller(line);
                    report.addSeller(seller);
                    debugLog(seller);
                    break;
                case SALE_IDENTIFIER:
                    Sale sale = saleConverter.convertSale(line);
                    report.addSale(sale);
                    debugLog(sale);
                    break;
                default:
                    LOG.error("It was not possible to parse: [{}]", line);
                    //emit error message
                    break;
            }
        }
        return report;
    }

    private void debugLog(Object o) {
        LOG.debug("Inserting into report dataset => [{}]", o.toString());
    }

    private String lineIdentifier(String line) {
        return line.substring(0, 3);
    }

    private String getFileName(Exchange exchange) {
        return exchange.getIn().getBody(GenericFileMessage.class).getGenericFile().getFileName();
    }
}
