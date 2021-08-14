package com.coffee.shop;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Product {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        DRINK, DESSERT;
    }


}
