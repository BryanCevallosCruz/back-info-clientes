package com.banco.proyecto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banco.proyecto.model.Empleado;
import com.banco.proyecto.service.dto.OutputEmpleadoDto;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    @Query(value = "SELECT BAN_PERSONA.*, BAN_EMPLEADO.cargoEmpleado AS cargoEmpleado \r\n"
        + "FROM BAN_PERSONA \r\n" 
        + "INNER JOIN BAN_EMPLEADO ON BAN_PERSONA.idPersona = BAN_EMPLEADO.idPersona \r\n"
        + "WHERE BAN_PERSONA.codigo=:codigo", nativeQuery = true)
    OutputEmpleadoDto getEmpleadoByCodigo(@Param("codigo") String codigo);
}
