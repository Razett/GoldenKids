package com.glkids.procurehub.repository;

import com.glkids.procurehub.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
