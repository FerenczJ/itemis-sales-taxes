package com.itemis.salestaxes.model;

import com.itemis.salestaxes.model.type.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void stringify_ShouldNotReturnNull() {
        final var item = new Item(1, Product.BOOK, 1.0);
        assertNotNull(item.stringify());
    }

}