package com.banco.proyecto.service.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private String nombre;
    private String apellido;
    private Long edad;
    private String numeroCuenta;
    private String fechaCreacionCuenta;
    private List<OutputMovimientosDto> movimientos;
    private BigDecimal saldoActual;
    
}
