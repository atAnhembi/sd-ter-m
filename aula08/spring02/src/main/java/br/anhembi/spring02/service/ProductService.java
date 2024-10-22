package br.anhembi.spring02.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Product;
import br.anhembi.spring02.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Optional<Product> insert(Product product) {
        if(product.getCod() > 0) {
            return Optional.empty();
        }
        return Optional.of(repo.save(product));
    }

    public boolean delete(int cod) {
        if(cod <= 0) {
            return false;
        }
        Optional<Product> prodOptional = repo.findById(cod);

        if(prodOptional.isEmpty()) {
            return false;
        }
        repo.deleteById(cod);
        return true;
    }

    public Optional<Product> update(Product product) {
        if(product.getCod() <= 0) {
            return Optional.empty();
        }
        Optional<Product> prodOptional = repo.findById(product.getCod());

        if(prodOptional.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(repo.save(product));
    }

    public Optional<Product> findById(int cod) {
        return repo.findById(cod);
    }

    public List<Product> findAll() {
        return (List<Product>) repo.findAll();
    }
}
