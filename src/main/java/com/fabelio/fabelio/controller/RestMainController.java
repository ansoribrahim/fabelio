package com.fabelio.fabelio.controller;

import com.fabelio.fabelio.pojo.Product;
import com.fabelio.fabelio.pojo.ProductHistory;
import com.fabelio.fabelio.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RestMainController {

	@Autowired
	private MainService mainService;

	@PostMapping("product")
	public ProductHistory saveProduct(@RequestParam String url) throws IOException {
		return mainService.saveProduct(url);
	}

	@RequestMapping("get_product_info")
	public Product postLink(@RequestParam String url) throws IOException {
		return mainService.getFabelioProductData(url);
	}

	@RequestMapping("get_products")
	public List<Product> getLinks() throws IOException {
		return mainService.getProducts();
	}
}
