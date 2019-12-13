package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import java.util.ArrayList;
// import java.util.List;
import java.net.URI;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
// import com.example.demo.dto.QueryParam;
// import com.example.demo.exception.UnprocessableException;

// import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
	// private List<Product> productDB = new ArrayList<>();
	@RequestMapping("/hello")
    public String helloHtml() {
        return "/index";    
	}
	
// 	@PostMapping(value = "/products")
// public ResponseEntity<Product> createProduct(@RequestBody Product request) {
//     boolean isIdDuplicated = productDB.stream()
//                     .anyMatch(p -> p.getId().equals(request.getId()));
//     if (isIdDuplicated) {
//         return ResponseEntity.unprocessableEntity().build();
//     }

//     Product product = new Product();
//     product.setId(request.getId());
// 	product.setName(request.getName());
// 	product.setPrice(request.getPrice());
//     productDB.add(product);

//     URI location = ServletUriComponentsBuilder
//             .fromCurrentRequest()
//             .path("/{id}")
//             .buildAndExpand(product.getId())
//             .toUri();

//     return ResponseEntity.created(location).body(product);
// }

	@Autowired
	private ProductService productService; 

	@GetMapping(value="/{id}")
	public ResponseEntity<Product> getMethodName(@PathVariable("id") String id) {
		Product product = productService.getProduct(id);
		return ResponseEntity.ok(product);
	}
	

	// @GetMapping
	// public ResponseEntity<List<Product>> getProducts(@ModelAttribute QueryParam param) {
	// 	List<Product> products = productService.getProducts(param);	
	// 	return ResponseEntity.ok(products);
	// }
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product request) {
	
		Product product = productService.createProduct(request);
		product.getId();	
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product.getId())
				.toUri();

		return ResponseEntity.created(location).body(product);
	}

	// @PutMapping(value="/{id}")
	// public ResponseEntity<Product> replaceProduct(
	// 	@PathVariable("id") String id, @RequestBody Product request) {
	// 		Product product = productService.replaceProduct(id, request);
	// 		return ResponseEntity.ok(product);
		
	// }

	// @DeleteMapping(value = "/{id}")
	// public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id) {
	// 		productService.deleteProduct(id);
	// 		return ResponseEntity.noContent().build();
	// }
	
}
