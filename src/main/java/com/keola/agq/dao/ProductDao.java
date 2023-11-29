package com.keola.agq.dao;

import com.keola.agq.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {

    Optional<Product> selectProductById(UUID id);

    List<Product> findAllProducts();

    Product insertProduct(Product product);

    void deleteProductById(UUID id);
}
