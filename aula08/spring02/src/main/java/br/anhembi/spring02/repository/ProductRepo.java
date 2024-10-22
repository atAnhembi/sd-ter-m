package br.anhembi.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring02.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
