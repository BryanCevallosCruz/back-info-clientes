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
@Table(name="BAN_MOVIMIENTOS")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimientos")
    private Long idMovimientos;

    @Column(name = "idPersona")
    private Long idPersona;

    @Column(name = "idTipoMovimiento")
    private Long idTipoMovimiento;

    @Column(name = "valorMovimiento")
    private String valorMovimiento;

    @Column(name = "detalle")
    private String detalle;
    
}
