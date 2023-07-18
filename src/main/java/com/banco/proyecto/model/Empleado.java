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
@Table(name="BAN_EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long idTipoMovimiento;

    @Column(name = "idPersona")
    private Long idPersona;

    @Column(name = "cargoEmpleado")
    private String cargoEmpleado;
    
}
