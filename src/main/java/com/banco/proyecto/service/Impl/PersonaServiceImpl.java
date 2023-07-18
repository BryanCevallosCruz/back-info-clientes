package com.banco.proyecto.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.proyecto.model.Persona;
import com.banco.proyecto.repository.EmpleadoRepository;
import com.banco.proyecto.repository.MovimientosRepository;
import com.banco.proyecto.repository.PersonaRepository;
import com.banco.proyecto.service.PersonaService;
import com.banco.proyecto.service.dto.OutputEmpleadoDto;
import com.banco.proyecto.service.dto.OutputMovimientosDto;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository repository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Persona> getAllPersona() {
        return repository.findAll();
    }

    @Override
    public List<OutputMovimientosDto> getMovimientosPersona(String codigo){
        return movimientosRepository.getMovimientosByCodigo(codigo);
    }

    @Override
    public List<Object> getMovimiento(){
        return movimientosRepository.getMovimientos();
    }

    @Override
    public OutputEmpleadoDto getEmpleadoPorCodigo(String codigo){
        return empleadoRepository.getEmpleadoByCodigo(codigo);
    }
    
}
