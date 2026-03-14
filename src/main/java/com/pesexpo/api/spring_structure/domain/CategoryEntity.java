package com.pesexpo.api.spring_structure.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


// pojo class
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50) private String name;

    @Column(columnDefinition = "TEXT") private String description;

    @OneToMany(mappedBy = "category") private List<ProductEntity> productEntities;
}
