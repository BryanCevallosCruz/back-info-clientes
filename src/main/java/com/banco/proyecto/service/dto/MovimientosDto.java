package com.banco.proyecto.service.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimientosDto {
    private String tipoMovimiento;
    private BigDecimal valorMovimiento;
    private String detalle;
}