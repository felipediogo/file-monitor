package br.com.felipediogo.camel.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    @Value("${file_extension}")
    private String fileExtension;
    @Value("${process_file_bean}")
    private String processorBean;

    @Override
    public void configure() {
        from(fileRoute())
                .convertBodyTo(String.class)
                .to(processorBean);
    }

    private String fileRoute() {
        return new StringBuilder()
                .append("file://")
                .append(homePath())
                .append(String.format("/data/in?move=.move&include=.*%s$", fileExtension)).toString();
    }

    private String homePath() {
        return System.getProperty("user.dir");
    }
}
