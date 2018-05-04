package br.com.felipediogo.components;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFile;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {
    private static final String FILE_EXTENSION = ".dat";

    @Override
    public void configure() throws Exception {
        from(buildFilePath())
                .filter(e -> e.getIn().getBody(GenericFile.class).getFileName().endsWith(FILE_EXTENSION))
                .convertBodyTo(String.class)
                .to("bean:myBean?method=log");
    }

    private String buildFilePath() {
        StringBuilder builder = new StringBuilder();
        builder.append("file://");
        builder.append(getHomePath());
        builder.append("/data/in?move=.move&include=.*.dat$");
        System.out.println(builder.toString());
        return builder.toString();
    }

    private String getHomePath() {
        return System.getProperty("user.dir");
    }
}
