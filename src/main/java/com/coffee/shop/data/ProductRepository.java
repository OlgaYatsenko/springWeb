package com.coffee.shop.data;

import com.coffee.shop.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository  extends CrudRepository<Product, String> {



}
