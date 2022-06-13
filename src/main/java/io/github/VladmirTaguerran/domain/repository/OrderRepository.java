package io.github.VladmirTaguerran.domain.repository;

import io.github.VladmirTaguerran.domain.entity.Customers;
import io.github.VladmirTaguerran.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomer(Customers customer);
}