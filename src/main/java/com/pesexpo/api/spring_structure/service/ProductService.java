package com.pesexpo.api.spring_structure.service;

import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse create(CreateProduct createProduct);

}
