package org.si.customerservice;

import org.si.customerservice.entities.Customer;
import org.si.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

@Bean
CommandLineRunner start(CustomerRepository customerRepository){

        return args -> {
            customerRepository.save(new Customer(null,"diallo","ggg@gmail.com"));
            customerRepository.save(new Customer(null,"mamadou","diallo@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
}


}
