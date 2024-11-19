package br.anhembi.spring02.dto;

import br.anhembi.spring02.model.Product;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank(message = "O campo nome é obrigatório")
    private String name;
    
    private double value;

    public Product toProduct() {
        return new Product(this.name, this.value);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    
}
