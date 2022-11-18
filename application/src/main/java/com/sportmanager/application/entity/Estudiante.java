package com.sportmanager.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "estudiantes")
public class Estudiante implements Serializable {

    @Id
    private int id;

    private String nombre;
    private String apellido;
    private int documento;
    private String tipo_documento;
    private String email;
    private String fecha_nacimiento;
    private int estatura;
    private int peso;
    private String genero;
    private boolean activo;
    private String password;
}
