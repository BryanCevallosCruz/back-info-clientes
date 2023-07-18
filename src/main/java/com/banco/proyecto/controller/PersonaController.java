package com.banco.proyecto.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.proyecto.model.Persona;
import com.banco.proyecto.service.PersonaService;
import com.banco.proyecto.service.dto.ClienteDto;
import com.banco.proyecto.service.dto.EmpleadoDto;
import com.banco.proyecto.service.dto.OutputEmpleadoDto;
import com.banco.proyecto.service.dto.OutputMovimientosDto;

import java.util.*;

@CrossOrigin(origins ="*", allowedHeaders ="*")
@RestController
@RequestMapping("/v1/persona")
public class PersonaController {

    @Autowired
    private final PersonaService service;

    public PersonaController(PersonaService service){
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> listarPersonas(){
        return service.getAllPersona();
    }

    @GetMapping(value="/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OutputMovimientosDto> movimientosPorCodigo(@PathVariable("codigo") String codigo){
        return service.getMovimientosPersona(codigo);
    }

    @GetMapping(value="/empleado/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public OutputEmpleadoDto empleadosPorCodigo(@PathVariable("codigo") String codigo){
        return service.getEmpleadoPorCodigo(codigo);
    }

    @GetMapping(value="/empleado/info/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpleadoDto infoEmpleadosPorCodigo(@PathVariable("codigo") String codigo){
        return service.getInfoEmpleadoByCodigo(codigo);
    }

    @GetMapping(value="/cliente/info/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDto infoClientePorCodigo(@PathVariable("codigo") String codigo){
        return service.getInfoClienteByCodigo(codigo);
    }
}
