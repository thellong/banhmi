package com.thellong.banhmi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final TYPE type;

    public static enum TYPE {
        SAUCE, PORK, BEEF, EGG, VEGES
    }
}
