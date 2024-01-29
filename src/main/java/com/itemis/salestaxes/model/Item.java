package com.itemis.salestaxes.model;

import com.itemis.salestaxes.model.type.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private long quantity;
    private Product product;
    private double price;

    public String stringify(){
        return STR."\{quantity} \{product.toString().toLowerCase().replaceAll("_", " ")}: \{price}";
    }
}
