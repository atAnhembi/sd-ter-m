package br.anhembi.spring02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.anhembi.spring02.dto.ProductDTO;
import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.service.ProductService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody @Valid ProductDTO productDto) {
        Optional<Product> optionalProduct = service.insert(productDto.toProduct());

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Product>(optionalProduct.get(), 
            HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Optional<Product> optionalProduct = service.update(product);

        if(optionalProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Product>(optionalProduct.get(), 
            HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> prodOptional = service.findById(id);

        if(prodOptional.isPresent()) {
            return ResponseEntity.ok(prodOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> produtos = service.findAll();

        if(produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
    }
}
