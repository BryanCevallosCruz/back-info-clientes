package com.banco.proyecto.model;

// import java.util.Date;
import java.sql.Date;
import java.math.BigDecimal;

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
@Table(name = "BAN_PERSONA")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long idPersona;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;
     
    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private Long edad;

    @Column(name = "numeroCuenta")
    private String numeroCuenta;

    @Column(name = "fechaCreacionCuenta")
    private Date fechaCreacionCuenta;

    @Column(name = "saldoActual")
    private BigDecimal saldoActual;


}
