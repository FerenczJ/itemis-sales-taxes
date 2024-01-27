package com.itemis.salestaxes.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Product {
    BOOK("book", ProductType.BOOK),
    MUSIC_CD("music CD", ProductType.OTHER),
    CHOCOLATE_BAR("chocolate bar", ProductType.FOOD),
    IMPORTED_BOX_OF_CHOCOLATES("imported box of chocolates", ProductType.FOOD),
    IMPORTED_BOTTLE_OF_PARFUME("imported bottle of perfume", ProductType.OTHER),
    BOTTLE_OF_PARFUME("bottle of perfume", ProductType.OTHER),
    PACKET_OF_HEADACHE_PILLS("packet of headache pills", ProductType.MEDICAL),
    BOX_OF_IMPORTED_CHOCOLATE("box of imported chocolates", ProductType.FOOD);

    @Getter
    private final String name;

    @Getter
    private final ProductType type;
}
