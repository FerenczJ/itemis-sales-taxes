package com.itemis.salestaxes.business;

import com.itemis.salestaxes.model.Item;

public interface TaxCalculator {
    double calculateTax(Item item);
}
