package org.example.entities;

import org.example.entities.enums.Rol;
import org.hibernate.engine.jdbc.SerializableClobProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_empleado")
    private String nombre;

    @Column(name = "apellido_empleado")
    private String apellido;

    @Column(name = "telefono_empleado")
    private String telefono;

    @Column(name = "email_empleado")
    private String email;

    @Column(name = "fecha_nacimiento_empleado")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_empleado")
    private Rol rol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagen_empleado")
    private ImagenEmpleado imagenEmpleado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario_empleado")
    private UsuarioEmpleado usuarioEmpleado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sucursal")
    private Sucursal sucursal;


    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public ImagenEmpleado getImagenEmpleado() {
        return imagenEmpleado;
    }

    public void setImagenEmpleado(ImagenEmpleado imagenEmpleado) {
        this.imagenEmpleado = imagenEmpleado;
    }

    public UsuarioEmpleado getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(UsuarioEmpleado usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }
}
