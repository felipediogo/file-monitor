package br.com.felipediogo.camel.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    private static final String FILE_EXTENSION = ".dat";

    @Override
    public void configure() {
        from(fileInRoute())
                .process("fileProcessor")
                .process("reportProcessor")
                .to(fileOutRoute());
    }

    private String fileInRoute() {
        return new StringBuilder()
                .append("file://")
                .append(homePath())
                .append(String.format("/data/in?charset=UTF-8&preMove=staging&moveFailed=../.failed&move=../.done&include=.*%s$", FILE_EXTENSION)).toString();
    }

    private String fileOutRoute() {
        return new StringBuilder()
                .append("file://")
                .append(homePath())
                .append("/data/out/")
                .toString();

    }

    private String homePath() {
        return System.getProperty("user.dir");
    }
}
