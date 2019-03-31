package pl.gpiwosz.estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EstateApplication {
    public static void main(String[] args) {
        SpringApplication.run(EstateApplication.class, args);
    }
}
