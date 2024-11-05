package br.anhembi.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring02.model.Seller;

public interface SellerRepo extends CrudRepository<Seller, Integer> {
    
}
