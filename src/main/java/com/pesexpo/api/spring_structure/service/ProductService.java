package com.pesexpo.api.spring_structure.service;

import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse create(CreateProduct createProduct);

    Page<ProductResponse> getAll(Integer pageNumber, Integer pageSize);

}
