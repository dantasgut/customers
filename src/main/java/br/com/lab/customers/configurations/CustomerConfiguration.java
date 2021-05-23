package br.com.lab.customers.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("br.com.lab.customers.repositories")
@ComponentScan({
		"br.com.lab.customers.api.services",
		"br.com.lab.customers.services"
		})
@EntityScan("br.com.lab.customers.repositories.entities")
public class CustomerConfiguration {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
