package br.com.felipediogo.camel.processors;


import org.springframework.stereotype.Component;

@Component
public class MyBean {


    public void log(String content) {
        System.out.println(content);
    }
}
