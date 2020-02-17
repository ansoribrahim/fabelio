package com.fabelio.fabelio.controller;

import com.fabelio.fabelio.pojo.Product;
import com.fabelio.fabelio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("product")
	public Product saveLink(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}

	@RequestMapping("post_link")
	public String postLink() {
		return "post_link";
	}
}
