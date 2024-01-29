package com.itemis.salestaxes.business;

import com.itemis.salestaxes.model.Item;
import com.itemis.salestaxes.util.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.itemis.salestaxes.util.ParseUtil.parseItem;
import static java.lang.Math.round;

public class Basket {

    private TaxCalculator taxCalculator;
    private List<Item> items = new ArrayList<>();
    private double sumTax = 0.0;
    private double sum = 0.0;

    public Basket(TaxCalculator taxCalculator, List<String> lines) throws ParseException {
        this.taxCalculator = taxCalculator;
        init(lines);
    }

    private void init(List<String> lines) throws ParseException {
        loadItems(lines);
        for(var item : items){
            var tax = taxCalculator.calculateTax(item);
            var price = round((item.getPrice() + tax)  * 100.0) / 100.0;
            item.setPrice(price);
            sumTax += tax;
            sum += item.getPrice();
        }
    }

    private void loadItems(List<String> lines) throws ParseException {
        for(var line : lines) {
            items.add(parseItem(line));
        }
    }

    public void out(){
        items.forEach(item -> System.out.println(item.stringify()));
        System.out.println(STR."Sales Taxes: \{sumTax}");
        System.out.println(STR."Total: \{sum}");
    }
}
