package com.mutrano.demo.mapper;

import org.mapstruct.Mapper;

import com.mutrano.demo.domain.Order;
import com.mutrano.demo.dtos.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	Order toEntity(OrderDTO orderDTO);
	
	OrderDTO toDTO(Order order);
}
