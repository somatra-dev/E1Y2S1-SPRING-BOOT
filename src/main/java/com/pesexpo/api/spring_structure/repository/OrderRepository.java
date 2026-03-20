package com.pesexpo.api.spring_structure.repository;

import com.pesexpo.api.spring_structure.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
