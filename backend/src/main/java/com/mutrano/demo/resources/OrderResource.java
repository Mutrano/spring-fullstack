package com.mutrano.demo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mutrano.demo.dtos.OrderDTO;
import com.mutrano.demo.services.OrderService;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value="orders")
public class OrderResource {
	private OrderService orderService;

	
	public OrderResource(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException{
		OrderDTO order = orderService.findById(id);
		return ResponseEntity.ok().body(order);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid OrderDTO dto ){
		 OrderDTO insertedOrderDTO = orderService.insert(dto);
		 URI uri = ServletUriComponentsBuilder.
				 	fromCurrentRequest().path("/{id}").buildAndExpand(insertedOrderDTO.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
}
