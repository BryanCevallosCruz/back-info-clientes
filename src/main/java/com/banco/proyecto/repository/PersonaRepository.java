package com.banco.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banco.proyecto.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    @Query(value = "SELECT * FROM BAN_PERSONA WHERE BAN_PERSONA.codigo=:codigo", nativeQuery = true)
    Persona getPersonasByCodigo(@Param("codigo") String codigo);
}
