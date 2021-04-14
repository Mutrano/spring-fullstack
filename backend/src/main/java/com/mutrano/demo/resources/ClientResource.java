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

import com.mutrano.demo.dtos.ClientDTO;
import com.mutrano.demo.services.ClientService;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value="clients")
public class ClientResource {
	private ClientService clientService;

	
	public ClientResource(ClientService clientService) {
		this.clientService=clientService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException{
		ClientDTO client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody @Valid ClientDTO dto ){
		 ClientDTO insertedClientDTO = clientService.insert(dto);
		 URI uri = ServletUriComponentsBuilder.
				 	fromCurrentRequest().path("/{id}").buildAndExpand(insertedClientDTO.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
}
