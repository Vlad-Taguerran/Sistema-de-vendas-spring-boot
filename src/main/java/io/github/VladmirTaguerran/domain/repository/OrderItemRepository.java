package io.github.VladmirTaguerran.domain.repository;

import io.github.VladmirTaguerran.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}