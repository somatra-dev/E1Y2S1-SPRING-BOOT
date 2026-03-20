package com.pesexpo.api.spring_structure.repository;

import com.pesexpo.api.spring_structure.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    Optional<CategoryEntity> findCategoryEntitiesById(Integer id);
}
