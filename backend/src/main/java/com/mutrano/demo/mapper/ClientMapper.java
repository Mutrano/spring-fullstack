package com.mutrano.demo.mapper;

import org.mapstruct.Mapper;

import com.mutrano.demo.domain.Client;
import com.mutrano.demo.dtos.ClientDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	Client toEntity(ClientDTO clientDTO);
	
	ClientDTO toDTO(Client client);
}
