package br.com.felipediogo.filemonitor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "br.com.felipediogo")
public class FileMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileMonitorApplication.class, args);
	}
}
