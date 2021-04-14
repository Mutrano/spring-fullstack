package com.mutrano.demo.services;

import org.springframework.stereotype.Service;

import com.mutrano.demo.domain.Client;
import com.mutrano.demo.dtos.ClientDTO;
import com.mutrano.demo.mapper.ClientMapper;
import com.mutrano.demo.repositories.ClientRepository;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	private ClientRepository clientRepository;
	private ClientMapper clientMapper;
	
	public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}
	
	public ClientDTO findById(Integer id) throws ResourceNotFoundException {
		Client foundClient = clientRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("category with id was not found"));
		
		return clientMapper.toDTO(foundClient);
	}
	
	public ClientDTO insert(ClientDTO dto) {
		Client client = clientMapper.toEntity(dto);
		Client insertedClient =clientRepository.save(client);
		return clientMapper.toDTO(insertedClient);
	}
}
