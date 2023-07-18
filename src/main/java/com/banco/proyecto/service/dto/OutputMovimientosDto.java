package com.banco.proyecto.service.dto;
import java.math.BigDecimal;

public interface OutputMovimientosDto {
    String getTipoMovimiento();
    BigDecimal getValorMovimiento();
    String getDetalle();
}
