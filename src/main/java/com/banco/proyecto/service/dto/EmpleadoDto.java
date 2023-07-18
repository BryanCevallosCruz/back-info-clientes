package com.banco.proyecto.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {
    private String nombre;
    private String apellido;
    private Long edad;
    private String numeroCuenta;
    private String cargoEmpleado;
    private List<OutputMovimientosDto> movimientos;
    private BigDecimal saldoActual;
}