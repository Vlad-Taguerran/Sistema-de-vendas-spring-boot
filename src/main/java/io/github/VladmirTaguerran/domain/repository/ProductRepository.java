package io.github.VladmirTaguerran.domain.repository;

import io.github.VladmirTaguerran.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}