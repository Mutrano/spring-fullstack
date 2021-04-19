package com.mutrano.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutrano.demo.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
