package com.linyy.interest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class })
@EnableScheduling
@EnableAsync
@PropertySource(value = {"classpath:application.properties"})
public class Application {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(Application.class, args);
        InetAddress ia = InetAddress.getLocalHost();
        System.err.println("访问地址:" + ia.getHostAddress());
    }
}
