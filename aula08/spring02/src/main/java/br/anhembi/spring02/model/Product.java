package br.anhembi.spring02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity // informa que esta classe será persistida no BD
public class Product {
    @Id // indica que este atributo é uma PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // número sequancial 1, 2, 3...
    private int cod;

    @Column(nullable = false)
    private String name;
    private double value;
    
    @ManyToOne
    @JoinColumn(name="id_seller")
    @JsonIgnoreProperties("productcs")
    private Seller seller;

    public Product(String name, double value){
        this.name = name;
        this.value = value;
    }
}
