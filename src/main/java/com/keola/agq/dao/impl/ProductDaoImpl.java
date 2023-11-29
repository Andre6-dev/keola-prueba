package com.keola.agq.dao.impl;

import com.keola.agq.dao.ProductDao;
import com.keola.agq.entity.Product;
import com.keola.agq.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * andre on 29/11/2023
 */
@Repository("product-jpa")
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository productRepository;

    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> selectProductById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }


}
