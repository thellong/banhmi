package com.thellong.banhmi.model.repos;

import org.springframework.data.repository.CrudRepository;

import com.thellong.banhmi.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
    
}
