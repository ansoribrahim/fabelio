package com.fabelio.fabelio.service;

import com.fabelio.fabelio.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MainServiceTest {

	@Autowired
	private MainService mainService;

	@Test
	void getFabelioProductData() {
		Product product = mainService.getFabelioProductData("https://fabelio.com/ip/meja-makan-cessi-new.html");
		assertEquals("Meja Makan Cessi - Glass Top", product.productName);
	}
}