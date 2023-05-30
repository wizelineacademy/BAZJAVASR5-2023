package com.wizeline.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wizeline.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findAll();
}