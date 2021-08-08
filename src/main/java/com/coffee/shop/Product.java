package com.coffee.shop;

import lombok.Data;

@Data
public class Product {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        DRINK, DESSERT;
    }


}
