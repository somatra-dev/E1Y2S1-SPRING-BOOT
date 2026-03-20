package com.pesexpo.api.spring_structure.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id private String code;

    @Column(nullable = false, length = 50) private String name;

    @Column(nullable = false) private BigDecimal price;

    @Column(nullable = false) private Integer qty;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean isAvailable;

    @ManyToOne
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<OrderLineEntity> orderLines;
}
