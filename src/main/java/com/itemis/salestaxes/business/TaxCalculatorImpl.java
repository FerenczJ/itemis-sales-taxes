package com.itemis.salestaxes.business;

import com.itemis.salestaxes.model.Item;
import static java.lang.Math.round;

public class TaxCalculatorImpl implements TaxCalculator {

    public static final double BASIC_SALES_TAX = 0.1;
    public static final double IMPORT_DUTY = 0.05;

    @Override
    public double calculateTax(Item item) {
        var result = 0.0;

        // apply basic sales tax
        if(item.getProduct().isSalesTaxApplies()) {
            result += item.getPrice() * BASIC_SALES_TAX;
        }

        // apply import duty
        if(item.getProduct().isImportDutyApplies()) {
            result += item.getPrice() * IMPORT_DUTY;
        }

        // round result to 2 decimal
        return round(result * 100.0) / 100.0;
    }
}
