package com.itemis.salestaxes.model.type;

import org.junit.jupiter.api.Test;

import static com.itemis.salestaxes.model.type.Product.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void isImportDutyApplies_ShouldReturnTrue() {
        assertTrue(IMPORTED_BOX_OF_CHOCOLATES.isImportDutyApplies());
        assertTrue(IMPORTED_BOX_OF_CHOCOLATES.isImportDutyApplies());
    }

    @Test
    void isSalesTaxApplies_ShouldReturnFalse() {
        assertFalse(BOOK.isSalesTaxApplies());
        assertFalse(CHOCOLATE_BAR.isSalesTaxApplies());
        assertFalse(PACKET_OF_HEADACHE_PILLS.isSalesTaxApplies());
        assertFalse(IMPORTED_BOX_OF_CHOCOLATES.isSalesTaxApplies());
    }
}