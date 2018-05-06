package br.com.felipediogo.camel.processors;

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

        System.out.println(exchange.getIn().getBody());
    }
}
