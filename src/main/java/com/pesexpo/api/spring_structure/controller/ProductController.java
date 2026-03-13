package com.pesexpo.api.spring_structure.controller;

import com.pesexpo.api.spring_structure.dto.request.CreateProduct;
import com.pesexpo.api.spring_structure.dto.request.UpdateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    @GetMapping
    public List<ProductResponse> getProducts(
            @RequestParam(defaultValue = "", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "0", required = false) Integer pageSize
    ) {
        log.info("Get products request");
        return List.of();
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
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse updateProduct(@RequestBody UpdateProduct updateProduct,
                                         @PathVariable Integer code) {
        log.info("Update partially product by code {}", code);
        return null;
    }

    @PutMapping("/{code}")
    public ProductResponse updateProductAll(@RequestBody UpdateProduct updateProduct,
                                         @PathVariable Integer code) {
        log.info("Update product by code {}", updateProduct);
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteProduct(@PathVariable Integer code) {
        log.info("Delete product by code {}", code);
    }
}
