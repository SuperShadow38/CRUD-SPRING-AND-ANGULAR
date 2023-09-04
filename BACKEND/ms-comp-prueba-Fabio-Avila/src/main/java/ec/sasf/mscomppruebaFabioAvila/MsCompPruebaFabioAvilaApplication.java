package ec.sasf.mscomppruebaFabioAvila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ec.sasf.model")
@ComponentScan({"ec.sasf.controller","ec.sasf.service","ec.sasf.repository","ec.sasf.config"})
@EnableJpaRepositories("ec.sasf.repository")

public class MsCompPruebaFabioAvilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompPruebaFabioAvilaApplication.class, args);
	}

}
