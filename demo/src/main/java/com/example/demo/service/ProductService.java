package com.example.demo.service;

// import java.util.ArrayList;
// import java.util.List;

// import com.example.demo.dto.QueryParam;
import com.example.demo.exception.NotFoundException;
// import com.example.demo.exception.UnprocessableException;
import com.example.demo.model.Product;
// import com.example.demo.repository.ProductRepository;
import com.example.demo.mapper.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
// import org.springframework.data.domain.Sort.Direction;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    // private List<Product> productDB = new ArrayList<>();

    public Product getProduct(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find product."));
    }

    public Product createProduct(Product request) {

		Product product = new Product();
		product.setId(request.getId());
		product.setName(request.getName());
		product.setPrice(request.getPrice());

		return repository.save(product);
    }

    // public Product replaceProduct(String id, Product request) {
    //     Product oldProduct = getProduct(id);

    //     Product product = new Product();
    //     product.setId(oldProduct.getId());
    //     product.setName(request.getName());
    //     product.setPrice(request.getPrice());

    //     return repository.save(product);
    // }

    // public void deleteProduct(String id) {
    //     repository.deleteById(id);
    // }

    // public List<Product> getProducts(QueryParam param) {
    //     String orderBy = param.getOrderBy();
    //     String sortRule = param.getSortRule();
    //     String keyword = param.getKeyword();

    //     Sort sort = null;
    //     if(orderBy != null && sortRule != null){
    //         Direction direction = sortRule.equals("asc")
    //                 ? Direction.ASC
    //                 : Direction.DESC;
        
    //         sort = new Sort(direction, orderBy);
    //     }

    //     if (sort != null) {
    //         return repository.findByNameLike(keyword, sort);
    //     }

    //     return repository.findByNameLike(keyword);
    // }
}