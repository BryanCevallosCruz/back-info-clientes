package com.banco.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.proyecto.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    
}
