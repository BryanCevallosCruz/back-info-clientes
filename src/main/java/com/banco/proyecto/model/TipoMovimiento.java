package com.banco.proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="BAN_TIPO_MOVIMIENTO")
public class TipoMovimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMovimiento")
    private Long idTipoMovimiento;

    @Column(name = "tipoMovimiento")
    private String tipoMovimiento;

}
