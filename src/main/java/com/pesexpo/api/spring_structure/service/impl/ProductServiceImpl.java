package com.pesexpo.api.spring_structure.service.impl;

import com.pesexpo.api.spring_structure.domain.CategoryEntity;
import com.pesexpo.api.spring_structure.domain.ProductEntity;
import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.request.UpdateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import com.pesexpo.api.spring_structure.repository.CategoryRepository;
import com.pesexpo.api.spring_structure.repository.ProductRepository;
import com.pesexpo.api.spring_structure.service.ProductService;
import com.pesexpo.api.spring_structure.util.GenerateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                .categoryName(saveProduct.getCategory().getName())
                .build();
    }

    @Override
    public Page<ProductResponse> getAll(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return productRepository.findAll(pageable)
                .map(this::productToProductResponse);
    }




    @Override
    public String deleteProductByCode(String code) {
        // 1. Validation if code don't have
        ProductEntity product = productRepository.findById(code).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));
        productRepository.delete(product);
        return code;
    }

    @Override
    public ProductResponse getProductByCode(String code) {
        // 1. validation if code don't have
        ProductEntity product = productRepository.findById(code).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));
        return this.productToProductResponse(product);
    }

    @Override
    public ProductResponse updateProductByCode(String code, UpdateProduct updateProduct) {
        ProductEntity product = productRepository.findById(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));

        this.updateProductToProductEntity(product, updateProduct);

        product = productRepository.save(product);

        return this.productToProductResponse(product);
    }

    public ProductResponse productToProductResponse(ProductEntity product) {
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .qty(product.getQty())
                .description(product.getDescription())
                .isAvailable(product.getIsAvailable())
                .categoryName(product.getCategory().getName())
                .build();
    }

    public void updateProductToProductEntity(ProductEntity entity, UpdateProduct updateProduct) {

        entity.setName(updateProduct.name());
        entity.setPrice(updateProduct.price());
        entity.setQty(updateProduct.qty());

    }
}
