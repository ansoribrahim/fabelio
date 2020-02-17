package com.fabelio.fabelio.controller;

import com.fabelio.fabelio.pojo.Product;
import com.fabelio.fabelio.repository.ProductRepository;
import com.fabelio.fabelio.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping("post_link")
	public String postLink() {
		return "post_link";
	}

	@RequestMapping("view_link")
	public String viewListOfLink() {
		return "view_link";
	}
}
