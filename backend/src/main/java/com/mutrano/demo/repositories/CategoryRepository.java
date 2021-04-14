package com.mutrano.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutrano.demo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
