package com.itemis.salestaxes.model.type;

public enum Product {
    BOOK,
    MUSIC_CD,
    CHOCOLATE_BAR,
    IMPORTED_BOX_OF_CHOCOLATES,
    IMPORTED_BOTTLE_OF_PERFUME,
    BOTTLE_OF_PERFUME,
    PACKET_OF_HEADACHE_PILLS,
    BOX_OF_IMPORTED_CHOCOLATE;


    public boolean isImportDutyApplies(){
        return switch(this) {
            case BOOK, BOTTLE_OF_PERFUME, MUSIC_CD -> true;
            default -> false;
        };
    }
}
