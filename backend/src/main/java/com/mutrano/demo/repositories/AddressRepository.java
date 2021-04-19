package com.mutrano.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutrano.demo.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
