package com.keola.agq.service;

import com.keola.agq.dao.ProductDao;
import com.keola.agq.dto.ProductDto;
import com.keola.agq.dto.UserDto;
import com.keola.agq.entity.Product;
import com.keola.agq.entity.User;
import com.keola.agq.mapper.ProductMapper;
import com.keola.agq.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

/**
 * andre on 29/11/2023
 */
@Slf4j(topic = "ProductService")
@Service
public class ProductService {

    private final ProductDao productDao;

    private final UserRepository userRepository;

    private final ProductMapper productMapper;

    public ProductService(@Qualifier("product-jpa") ProductDao productDao, UserRepository userRepository, ProductMapper productMapper) {
        this.productDao = productDao;
        this.userRepository = userRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {
        log.info("Getting all products");
        return this.productDao.findAllProducts()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(UUID productId) {
        log.info("Getting product with id [{}]", productId);
        return this.productDao.selectProductById(productId)
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductDto createProduct(UUID userId, ProductDto productDto) {
        log.info("Creating product with name [{}]", productDto.name());
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productMapper.toEntity(productDto);

        product.setUser(user);
        return productMapper.toDto(product);
    }

    public void deleteProductById(UUID id) {
        this.productDao.deleteProductById(id);
    }
}
