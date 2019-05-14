package com.ecommerce.voucher.repository;

import org.springframework.data.repository.CrudRepository;
import com.ecommerce.voucher.entity.Order;

public interface OrderRepository extends CrudRepository<Order, String> {

}
