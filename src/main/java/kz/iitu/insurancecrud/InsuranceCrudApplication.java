package kz.iitu.insurancecrud;

import kz.iitu.insurancecrud.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class InsuranceCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceCrudApplication.class, args);
    }

}
