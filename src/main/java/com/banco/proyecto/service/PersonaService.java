package com.banco.proyecto.service;

import java.util.List;

import com.banco.proyecto.model.Persona;
import com.banco.proyecto.service.dto.ClienteDto;
import com.banco.proyecto.service.dto.EmpleadoDto;
import com.banco.proyecto.service.dto.OutputEmpleadoDto;
import com.banco.proyecto.service.dto.OutputMovimientosDto;

public interface PersonaService {
    List<Persona> getAllPersona();
    List<OutputMovimientosDto> getMovimientosPersona(String codigo);
    OutputEmpleadoDto getEmpleadoPorCodigo(String codigo);
    EmpleadoDto getInfoEmpleadoByCodigo(String codigo);
    ClienteDto getInfoClienteByCodigo(String codigo);
}
