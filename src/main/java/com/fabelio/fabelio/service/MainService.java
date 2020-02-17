package com.fabelio.fabelio.service;

import com.fabelio.fabelio.pojo.Image;
import com.fabelio.fabelio.pojo.Product;
import com.fabelio.fabelio.pojo.ProductHistory;
import com.fabelio.fabelio.repository.ProductRepository;
import com.fabelio.fabelio.repository.ProductRepositoryHistory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MainService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductRepositoryHistory productRepositoryHistory;

	@Autowired
	MongoTemplate mongoTemplate;

	public Product getFabelioProductData(String url) throws IOException {
		Document document = Jsoup.connect(url).get();
		Product product = new Product();

		if ( document.select(".product-options-bottom").size()>0) throw new IOException("Product with options not supported");

		String priceString = document.select(".product-info-price [id^='product-price-'] .price").text();
		int priceInt = Integer.parseInt(priceString.substring(3, priceString.length()).replace(".", ""));
		BigDecimal priceBigDecimal = new BigDecimal(priceInt);

		Elements scriptElements = document.select("script");

		for (Element element : scriptElements) {
			if (element.data().contains("[data-gallery-role=gallery-placeholder]")) {
				String dataString = element.data();

				Pattern pattern = Pattern.compile("\"data\": (.*?),\n");
				Matcher matcher = pattern.matcher(dataString);

				while (matcher.find()) {
					Gson gson = new Gson();
					List<Image> listimg = gson.fromJson(matcher.group(1), new TypeToken<List<Image>>(){}.getType());
					product.setImages(listimg);
				}
				break;
			}
		}

		product.setProductName(document.select("span.base").get(0).text());
		product.setPrice(priceBigDecimal);
		product.setDescription(document.select("#description p").text());

		return product;
	}

	public ProductHistory saveProduct(String url) throws IOException {
		Product product = getFabelioProductData(url);
		product.setProductLink(url);
		product.setSaveTime(new Date());

		ProductHistory result = null;
		if (productRepository.findByProductLink(product.getProductLink()).isEmpty()) {
			result = new ProductHistory(productRepository.save(product));
		} else {
			ProductHistory productHistory = new ProductHistory(product);
			result = productRepositoryHistory.save(productHistory);
		}

		return result;
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
}
