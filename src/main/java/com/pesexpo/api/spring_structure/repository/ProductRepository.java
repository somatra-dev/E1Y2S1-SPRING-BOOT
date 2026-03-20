package com.pesexpo.api.spring_structure.repository;

import com.pesexpo.api.spring_structure.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Optional<ProductEntity> findByName(String name);

}
