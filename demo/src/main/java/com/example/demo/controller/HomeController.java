package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.net.URI;
import java.util.ArrayList;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.dto.QueryParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/products")
public class HomeController {

	@Autowired
	private ProductService productService; 

	private List<Product> productDB = new ArrayList<>();

	@GetMapping(value="/{id}")
	public ResponseEntity<Product> getMethodName(@PathVariable("id") String id) {
		Product product = productService.getProduct(id);
		return ResponseEntity.ok(product);
	}
	

	@GetMapping
	public ResponseEntity<List<Product>> getProducts(@ModelAttribute QueryParam param) {
		List<Product> products = productService.getProduct(param);	
		return ResponseEntity.ok(products);
	}
	
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product request) {
		Product product = productService.createProduct(request);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product.getId())
				.toUri();

		return ResponseEntity.created(location).body(product);
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Product> putProduct(@PathVariable("id") String id, @RequestBody Product request) {
		
		
		Optional<Product> productOp = productDB.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst();
	
		if (!productOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	
		Product oldProduct = productOp.get();
		int productIndex = productDB.indexOf(oldProduct);
	
		Product product = new Product();
		product.setId(oldProduct.getId());
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		productDB.set(productIndex, product);
	
		return ResponseEntity.ok().body(product);
		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id) {
		Optional<Product> productOp = productDB.stream()
				.filter(p -> p.getId().equals(id))
				.findFirst();

		if (productOp.isPresent()) {
			Product product = productOp.get();
			productDB.remove(product);

			return ResponseEntity.ok().body(product);
		}

		return ResponseEntity.notFound().build();
	}
	
}
