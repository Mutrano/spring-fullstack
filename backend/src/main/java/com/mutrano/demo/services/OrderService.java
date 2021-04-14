package com.mutrano.demo.services;

import org.springframework.stereotype.Service;

import com.mutrano.demo.domain.Order;
import com.mutrano.demo.dtos.OrderDTO;
import com.mutrano.demo.mapper.OrderMapper;
import com.mutrano.demo.repositories.OrderRepository;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private OrderMapper orderMapper;
	
	public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
	}
	
	public OrderDTO findById(Integer id) throws ResourceNotFoundException {
		Order foundOrder = orderRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("category with id was not found"));
		
		return orderMapper.toDTO(foundOrder);
	}
	
	public OrderDTO insert(OrderDTO dto) {
		Order order = orderMapper.toEntity(dto);
		Order insertedOrder =orderRepository.save(order);
		return orderMapper.toDTO(insertedOrder);
	}
}
