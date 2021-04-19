package com.mutrano.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutrano.demo.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
