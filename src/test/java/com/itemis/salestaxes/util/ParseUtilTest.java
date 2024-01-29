package com.itemis.salestaxes.util;

import org.junit.jupiter.api.Test;

import static com.itemis.salestaxes.util.ParseUtil.parseItem;
import static org.junit.jupiter.api.Assertions.*;

class ParseUtilTest {

    @Test
    void parseItem_withValidInput_shouldParseAsExpected() throws ParseException {
        var item = parseItem("1 chocolate bar at 0.85");

        assertNotNull(item);
        assertNotEquals(0L, item.getQuantity());
        assertNotNull(item.getProduct());
        assertNotEquals(0.0, item.getPrice());
    }

    @Test
    void parseItem_withInvalidQuantity_shouldThrowParseException() {
        assertThrows(ParseException.class, () ->  parseItem("a a 1") );
    }

    @Test
    void parseItem_withInvalidProduct_shouldThrowParseException() {
        assertThrows(ParseException.class, () ->  parseItem("1 invalid at 1.0") );
    }

    @Test
    void parseItem_withInvalidPrice_shouldThrowParseException() {
        assertThrows(ParseException.class, () ->  parseItem("1 book at invalid") );
    }

}