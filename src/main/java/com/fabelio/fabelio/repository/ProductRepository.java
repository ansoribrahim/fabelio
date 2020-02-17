package com.fabelio.fabelio.repository;

import com.fabelio.fabelio.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
