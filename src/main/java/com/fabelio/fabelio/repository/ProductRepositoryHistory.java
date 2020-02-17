package com.fabelio.fabelio.repository;

import com.fabelio.fabelio.pojo.Product;
import com.fabelio.fabelio.pojo.ProductHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepositoryHistory extends MongoRepository<ProductHistory, String> {
}
