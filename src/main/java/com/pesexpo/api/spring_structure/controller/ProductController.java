package com.pesexpo.api.spring_structure.controller;

import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.request.UpdateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import com.pesexpo.api.spring_structure.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize
    ) {
        log.info("Get products request");
        return productService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/{code}")
    public ProductResponse getProduct(
            @PathVariable() Integer code,
            @RequestParam(defaultValue = "Somatra", required = false) String name,
            @RequestParam(defaultValue = "0", required = false) BigDecimal price
    ) {
        log.info("Get product by code {}", code);

        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createProduct(
            @RequestBody CreateProduct createProduct
    ) {
        log.info("Create product {}", createProduct);
        return productService.create(createProduct);
    }

    @PutMapping("/{code}")
    public ProductResponse updateProduct(
            @PathVariable String code,
            @RequestBody UpdateProduct updateProduct
    ){
        log.info("Update product : {}", updateProduct);
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse patchProduct(
            @PathVariable String code,
            @RequestBody UpdateProduct updateProduct
    ){
        log.info("Patch Product : {}", updateProduct);
        return null;
    }

    @DeleteMapping("{code}")
    public String deleteProductByCode(@PathVariable String code){
        return productService.deleteProductByCode(code);
    }
}
