package org.si.inventorysevice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventorySeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorySeviceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRespository productRespository){

        return args -> {
            productRespository.save(new Product( null,"ordi",80000,99));
            productRespository.save(new Product( null,"Smart Tv",7889,55));
            productRespository.findAll().forEach(c->{
                System.out.println(c.getName());
            });
        };
    }


}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double  price;
    private double quantity;

}
@RepositoryRestResource
interface ProductRespository extends JpaRepository<Product, Long> {



}