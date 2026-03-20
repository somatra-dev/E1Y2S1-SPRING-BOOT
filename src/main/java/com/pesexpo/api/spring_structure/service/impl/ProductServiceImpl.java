package com.pesexpo.api.spring_structure.service.impl;

import com.pesexpo.api.spring_structure.domain.CategoryEntity;
import com.pesexpo.api.spring_structure.domain.ProductEntity;
import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import com.pesexpo.api.spring_structure.repository.CategoryRepository;
import com.pesexpo.api.spring_structure.repository.ProductRepository;
import com.pesexpo.api.spring_structure.service.ProductService;
import com.pesexpo.api.spring_structure.util.GenerateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl (ProductRepository productRepository
                               , CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponse create(CreateProduct createProduct)  {
        // validation category by id
        CategoryEntity categoryEntity = categoryRepository.findCategoryEntitiesById(createProduct.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + createProduct.categoryId() + " not found"));

        // Transfer data to db
        ProductEntity product = new ProductEntity();
        product.setName(createProduct.name());
        product.setPrice(createProduct.price());
        product.setDescription(createProduct.description());
        product.setQty(createProduct.qty());
        product.setCategory(categoryEntity);
        product.setIsAvailable(true);

        product.setCode(GenerateUtil.generateRandomCode());

        ProductEntity saveProduct = productRepository.save(product);

        return ProductResponse.builder()
                .code(saveProduct.getCode())
                .name(saveProduct.getName())
                .price(saveProduct.getPrice())
                .qty(saveProduct.getQty())
                .description(saveProduct.getDescription())
                .isAvailable(saveProduct.getIsAvailable())
                .categoryId(saveProduct.getCategory().getName())
                .build();
    }
}
