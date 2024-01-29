package com.itemis.salestaxes.business;

import com.itemis.salestaxes.model.Item;
import com.itemis.salestaxes.model.type.Product;

import com.itemis.salestaxes.model.type.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorImplTest {

    private TaxCalculator taxCalculator = new TaxCalculatorImpl();

    @BeforeEach
    void setUp() {
    }

    private final double TEST_PRICE = 1.0;
    private final long TEST_QUANTITY = 1L;
    private List<Item> testItems = List.of(
            new Item(TEST_QUANTITY, Product.BOOK, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.MUSIC_CD, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.CHOCOLATE_BAR, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.IMPORTED_BOX_OF_CHOCOLATES, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.BOTTLE_OF_PERFUME, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.PACKET_OF_HEADACHE_PILLS, TEST_PRICE),
            new Item(TEST_QUANTITY, Product.BOX_OF_IMPORTED_CHOCOLATE, TEST_PRICE));

    private final double BASE_SALES_TAX = TEST_PRICE * TaxCalculatorImpl.BASIC_SALES_TAX;
    private final double IMPORT_DUTY_TAX = TEST_PRICE * TaxCalculatorImpl.IMPORT_DUTY;

    @Test
    void calculateTax_shouldApplyBasicSalesTax() {
        var expected = round((BASE_SALES_TAX + IMPORT_DUTY_TAX) * 100.0 ) / 100.0 ;
        var importDutyItems = testItems.stream()
                            .filter(x-> x.getProduct().isImportDutyApplies())
                            .toList();


        importDutyItems.forEach(item -> {
            assertEquals(expected, taxCalculator.calculateTax(item));
        });
    }

    @Test
    void calculateTax_shouldNotApplyBasicSalesTax() {
        var expected = round(IMPORT_DUTY_TAX * 100.0 ) / 100.0 ;
        var notImportDutyItems = testItems.stream()
                .filter(x-> !x.getProduct().isImportDutyApplies())
                .toList();


        notImportDutyItems.forEach(item -> {
            assertEquals(expected, taxCalculator.calculateTax(item));
        });
    }
}