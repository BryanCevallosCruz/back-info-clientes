package com.banco.proyecto.service;

import java.util.List;

import com.banco.proyecto.model.Persona;
import com.banco.proyecto.service.dto.OutputEmpleadoDto;
import com.banco.proyecto.service.dto.OutputMovimientosDto;

public interface PersonaService {
    List<Persona> getAllPersona();
    List<OutputMovimientosDto> getMovimientosPersona(String codigo);
    List<Object> getMovimiento();
    OutputEmpleadoDto getEmpleadoPorCodigo(String codigo);
}
