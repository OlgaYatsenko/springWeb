package com.coffee.shop.data;

import com.coffee.shop.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends CrudRepository<Order, Long> {


}
