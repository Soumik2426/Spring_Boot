package com.codingshuttle.Module1.Chapter3.controller;

import com.codingshuttle.Module1.Chapter3.entities.ProductEntity;
import com.codingshuttle.Module1.Chapter3.repositories.ProductRepository;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final int PAGESIZE=5;

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productRepository.findByProductCategory("Electronics");
    }

    @GetMapping("/sort")
    public List<ProductEntity> getAllProductsSorted(@RequestParam(defaultValue = "id") String sortBy,
                                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "") String title){
        Pageable pageable= PageRequest.of(
                pageNo,
                PAGESIZE,
                Sort.by(sortBy));
        return productRepository.findByProductCategory(title, pageable);
    }
}
