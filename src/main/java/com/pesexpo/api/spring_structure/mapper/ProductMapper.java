package com.pesexpo.api.spring_structure.mapper;

import com.pesexpo.api.spring_structure.domain.ProductEntity;
import com.pesexpo.api.spring_structure.dto.request.PatchUpdateProduct;
import com.pesexpo.api.spring_structure.dto.request.UpdateProduct;
import com.pesexpo.api.spring_structure.dto.response.ProductResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryName", source = "category.name")
    ProductResponse toProductResponse(ProductEntity productEntity);

    void updateProductToProductEntity(@MappingTarget ProductEntity productEntity, UpdateProduct updateProduct);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void patchUpdateToProductEntity(@MappingTarget ProductEntity productEntity, PatchUpdateProduct patchUpdateProduct);

}
