package io.github.VladmirTaguerran;

import io.github.VladmirTaguerran.domain.entity.Customers;
import io.github.VladmirTaguerran.domain.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String applicationName;

    @Bean
    public CommandLineRunner init(@Autowired CustomersRepository customers){
        return args -> {
            customers.save(new Customers("teste1"));

            List<Customers> listAll = customers.listAll();
            listAll.forEach(System.out::println);
        };


    }
    @GetMapping("/")
    public String helloWord(){
        return applicationName;
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
