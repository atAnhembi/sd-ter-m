package br.anhembi.spring02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Product insert(Product product) {
        return repo.save(product);
    }

    public Optional<Product> findById(int cod) {
        return repo.findById(cod);
    }
}
