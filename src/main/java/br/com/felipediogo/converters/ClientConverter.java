package br.com.felipediogo.converters;

import br.com.felipediogo.camel.processors.ReportProcessor;
import br.com.felipediogo.models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class ClientConverter {
    private static final int CNPJ_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int BUSINESS_INDEX = 3;
    private static final String SPLITTER = "ç";

    static Logger LOG = LoggerFactory.getLogger(ClientConverter.class);

    public Optional<Client> convertClient(String line) {
        try {
            return of(new Client(
                    lineValue(line, CNPJ_INDEX),
                    lineValue(line, NAME_INDEX),
                    lineValue(line, BUSINESS_INDEX)));
        } catch (Exception e) {
            LOG.error("Não foi possível parsear a linha : [{}]", line);
            return empty();
        }

    }

    private String lineValue(String line, int index) {
        return line.split(SPLITTER)[index];
    }
}
