package io.github.VladmirTaguerran.api;

import io.github.VladmirTaguerran.domain.entity.Customers;
import io.github.VladmirTaguerran.domain.repository.CustomersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/customers")
public class CutomerController {
    private CustomersRepository customers;
    public CutomerController(CustomersRepository customers){
        this.customers = customers;
    }
   @GetMapping("/api/customers/{id}")
    @ResponseBody
    public ResponseEntity<Customers> getCutomer(@PathVariable Integer id){
       Optional<Customers> customer = customers.findById(id);
       return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

   }
}
