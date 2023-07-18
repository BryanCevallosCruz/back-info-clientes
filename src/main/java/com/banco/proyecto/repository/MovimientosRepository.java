package com.banco.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banco.proyecto.model.Movimientos;
import com.banco.proyecto.service.dto.OutputMovimientosDto;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
    @Query(value = "SELECT BAN_TIPO_MOVIMIENTO.tipoMovimiento AS tipoMovimiento, BAN_MOVIMIENTOS.valorMovimiento AS valorMovimiento, \r\n"
            + "BAN_MOVIMIENTOS.detalle AS detalle FROM BAN_MOVIMIENTOS \r\n"
            + "INNER JOIN BAN_PERSONA ON BAN_PERSONA.idPersona = BAN_MOVIMIENTOS.idPersona \r\n"
            + "INNER JOIN BAN_TIPO_MOVIMIENTO ON BAN_TIPO_MOVIMIENTO.idTipoMovimiento = BAN_MOVIMIENTOS.idTipoMovimiento\r\n"
            + "WHERE BAN_PERSONA.codigo=:codigo", nativeQuery = true)
    List<OutputMovimientosDto> getMovimientosByCodigo(@Param("codigo") String codigo);
}
