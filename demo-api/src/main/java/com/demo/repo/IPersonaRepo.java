package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.model.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
