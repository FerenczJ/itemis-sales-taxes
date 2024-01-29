package com.itemis.salestaxes.model.type;

public enum Product {
    BOOK,
    MUSIC_CD,
    CHOCOLATE_BAR,
    IMPORTED_BOX_OF_CHOCOLATES,
    IMPORTED_BOTTLE_OF_PERFUME,
    BOTTLE_OF_PERFUME,
    PACKET_OF_HEADACHE_PILLS;


    public boolean isImportDutyApplies() {
        return switch(this) {
            case IMPORTED_BOX_OF_CHOCOLATES, IMPORTED_BOTTLE_OF_PERFUME -> true;
            default -> false;
        };
    }

    public boolean isSalesTaxApplies() {
        return switch(this) {
            case BOOK, CHOCOLATE_BAR, PACKET_OF_HEADACHE_PILLS, IMPORTED_BOX_OF_CHOCOLATES -> false;
            default -> true;
        };
    }
}
