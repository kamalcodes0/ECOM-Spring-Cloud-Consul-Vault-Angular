package com.maven.clientservice;

import com.maven.clientservice.entities.Customer;
import com.maven.clientservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository)
    {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("kamal").email("kamal@gmail.com").build(),
                    Customer.builder().name("med").email("med@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);


        };
    }

}
