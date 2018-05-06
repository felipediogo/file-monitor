package br.com.felipediogo.filemonitor;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
@ComponentScan(value = "br.com.felipediogo")
public class FileMonitorApplication {

	public static void main(String[] args) {
		GenericXmlApplicationContext factory = new GenericXmlApplicationContext();
		factory.load("classpath:META-INF/beans.xml");
		factory.refresh();
		SpringApplication.run(FileMonitorApplication.class, args);
	}
}
