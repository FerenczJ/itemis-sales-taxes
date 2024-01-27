package com.itemis.salestaxes.model;

import com.itemis.salestaxes.model.type.Product;
import lombok.Data;

@Data
public class Item {
    private long quantity;
    private Product product;
    private double price;
}
