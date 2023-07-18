package com.banco.proyecto.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.banco.proyecto.model.Empleado;
import com.banco.proyecto.model.Persona;
import com.banco.proyecto.repository.EmpleadoRepository;
import com.banco.proyecto.repository.MovimientosRepository;
import com.banco.proyecto.repository.PersonaRepository;
import com.banco.proyecto.service.PersonaService;
import com.banco.proyecto.service.dto.ClienteDto;
import com.banco.proyecto.service.dto.EmpleadoDto;
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
    public OutputEmpleadoDto getEmpleadoPorCodigo(String codigo){
        return empleadoRepository.getEmpleadoByCodigo(codigo);
    }

    @Override
    public EmpleadoDto getInfoEmpleadoByCodigo(String codigo){
        OutputEmpleadoDto empleadoDto = empleadoRepository.getEmpleadoByCodigo(codigo);
        List<OutputMovimientosDto> movimientosDto = movimientosRepository.getMovimientosByCodigo(codigo);


        BigDecimal saldoActual = new BigDecimal(0);
        for(OutputMovimientosDto item: movimientosDto){
            if(item.getTipoMovimiento().equals("Credito")){
                saldoActual = saldoActual.add(item.getValorMovimiento());
                System.out.println(item.getTipoMovimiento()); 
            } else if (item.getTipoMovimiento().equals("Debito")){
                saldoActual = saldoActual.subtract(item.getValorMovimiento());
            }
        }

        EmpleadoDto empleado = new EmpleadoDto();
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEdad(empleadoDto.getEdad());
        empleado.setNumeroCuenta(empleadoDto.getNumeroCuenta());
        empleado.setCargoEmpleado(empleadoDto.getCargoEmpleado());
        empleado.setMovimientos(movimientosDto);
        empleado.setSaldoActual(saldoActual);
        

        return empleado;
    }
    

    @Override
    public ClienteDto getInfoClienteByCodigo(String codigo){
        Persona personaDto = repository.getPersonasByCodigo(codigo);

        List<OutputMovimientosDto> movimientosDto = movimientosRepository.getMovimientosByCodigo(codigo);

        BigDecimal saldoActual = new BigDecimal(0);
        for(OutputMovimientosDto item: movimientosDto){
            if(item.getTipoMovimiento().equals("Credito")){
                saldoActual = saldoActual.add(item.getValorMovimiento());
                System.out.println(item.getTipoMovimiento()); 
            } else if (item.getTipoMovimiento().equals("Debito")){
                saldoActual = saldoActual.subtract(item.getValorMovimiento());
            }
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formato.format(personaDto.getFechaCreacionCuenta());


        ClienteDto cliente = new ClienteDto();
        cliente.setNombre(personaDto.getNombre());
        cliente.setApellido(personaDto.getApellido());
        cliente.setEdad(personaDto.getEdad());
        cliente.setNumeroCuenta(personaDto.getNumeroCuenta());
        cliente.setFechaCreacionCuenta(fechaFormateada);
        cliente.setMovimientos(movimientosDto);
        cliente.setSaldoActual(saldoActual);
        

        return cliente;
    }
}
