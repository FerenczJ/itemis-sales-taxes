package com.itemis.salestaxes.business;

import com.itemis.salestaxes.model.Item;
import com.itemis.salestaxes.model.type.ProductType;

import static java.lang.Math.round;

public class TaxCalculatorImpl implements TaxCalculator {

    public static final double BASIC_SALES_TAX = 0.1;
    public static final double IMPORT_DUTY = 0.05;

    @Override
    public double calculateTax(Item item) {
        var result = 0.0;

        // apply basic sales tax
        if(ProductType.OTHER.equals(item.getProduct().getType())) {
            result += item.getPrice() * BASIC_SALES_TAX;
        }

        // apply import duty
        result += item.getPrice() * IMPORT_DUTY;

        // round result to 2 decimal
        return round(result * 100.0) / 100.0;
    }
}
