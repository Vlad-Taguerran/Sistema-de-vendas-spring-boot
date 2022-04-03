package io.github.VladmirTaguerran.services;


import io.github.VladmirTaguerran.models.Customers;
import io.github.VladmirTaguerran.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CutomersServices {

    private CustomersRepository repository;

    @Autowired
    CutomersServices(CustomersRepository customersRepository){
        this.repository = customersRepository;
    }
    private void saveCustomers(Customers customers){
        validate(customers);
        this.repository.persist(customers);


    }
    private void validate(Customers customers){

    }
}
