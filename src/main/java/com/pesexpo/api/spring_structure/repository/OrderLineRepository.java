package com.pesexpo.api.spring_structure.repository;

import com.pesexpo.api.spring_structure.domain.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, UUID> {
}
