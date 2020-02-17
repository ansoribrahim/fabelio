package com.fabelio.fabelio.repository;

import com.fabelio.fabelio.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
	@Query(value="{'productLink': ?0}", fields="{'productLink' : 1}")
	public List<Product> findByProductLink(String productLink);
}
