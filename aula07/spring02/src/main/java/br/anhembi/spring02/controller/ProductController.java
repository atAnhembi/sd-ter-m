package br.anhembi.spring02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        Product newProduct = service.insert(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> prodOptional = service.findById(id);

        if(prodOptional.isPresent()) {
            return ResponseEntity.ok(prodOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
