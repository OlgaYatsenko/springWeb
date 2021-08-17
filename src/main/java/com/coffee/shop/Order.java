package com.coffee.shop;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name="Order_Products")
public class Order{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToMany(targetEntity=Product.class)
    @Size(min=1, message="You must choose at least 1 product")
    //@Size(min=1, message="You must choose at least 1 ingredient")
    private List<Product> products = new ArrayList<>();
}