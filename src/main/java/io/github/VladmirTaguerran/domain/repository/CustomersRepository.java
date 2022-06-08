package io.github.VladmirTaguerran.domain.repository;


import io.github.VladmirTaguerran.domain.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomersRepository extends JpaRepository<Customers, Integer> {

        List<Customers> findByNameLike(String name);





}
