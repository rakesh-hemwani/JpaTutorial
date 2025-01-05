package com.whitewolfs.rakesh.project.JpaTutorial.controllers;

import com.whitewolfs.rakesh.project.JpaTutorial.entities.ProductEntity;
import com.whitewolfs.rakesh.project.JpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    private final Integer PAGE_SIZE = 5;
    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber,
                                              @RequestParam(defaultValue = "") String title){
//        return productRepository.findByOrderByPrice();
//        //return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "quantity"));
//        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy),
//                Sort.Order.asc("quantity")));

        Pageable pageable = PageRequest.of(pageNumber,
                PAGE_SIZE
        , Sort.by(sortBy));

//        return productRepository.findAll(pageable).getContent();
        return productRepository.findByTitleContaining(title,pageable);
    }
}
