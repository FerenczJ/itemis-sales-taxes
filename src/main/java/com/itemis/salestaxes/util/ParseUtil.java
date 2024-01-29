package com.itemis.salestaxes.util;

import com.itemis.salestaxes.model.Item;
import com.itemis.salestaxes.model.type.Product;

public class ParseUtil {
    public static Item parseItem(String input) throws ParseException {
        String[] res = input.replaceFirst("\\s+", ";")
                            .split(" at |;", 3);

        if(res.length != 3) throw new ParseException("Unable to parse item into 3 separate part.");

        return new Item(parseItemQuantity(res[0]),
                parseItemProduct(res[1].replace(" ", "_").toUpperCase()),
                parseItemPrice(res[2]));
    }

    private static long parseItemQuantity(String input) throws ParseException {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Unable to parse item's quantity from '%s'", input));
        }
    }

    private static double parseItemPrice(String input) throws ParseException  {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Unable to parse item's price from '%s'", input));
        }
    }

    private static Product parseItemProduct(String input) throws ParseException {
        try {
            return Product.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new ParseException(String.format("Unable to parse item's product from '%s'", input));
        }
    }
}
