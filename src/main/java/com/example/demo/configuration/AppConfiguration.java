package com.example.demo.configuration;

import com.example.demo.service.PrinterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class AppConfiguration {

    @Bean
    public PrinterServiceImpl printerServiceImplFirst() {
        return new PrinterServiceImpl();
    }

    @Bean
    public PrinterServiceImpl printerServiceImplSecond() {
        return new PrinterServiceImpl();
    }

    @Bean
    public PrinterServiceImpl printerServiceImplThird() {
        return new PrinterServiceImpl();
    }
}
