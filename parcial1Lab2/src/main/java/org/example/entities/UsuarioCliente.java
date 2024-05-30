package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios_clientes")
public class UsuarioCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "auth_id")
    private String auth0Id;

    @Column(name = "nombre_usuario")
    private String username;

    @OneToOne(mappedBy = "usuarioCliente")
    private Cliente cliente;

    public UsuarioCliente() {
    }

    public UsuarioCliente(String auth0Id, String username) {
        this.auth0Id = auth0Id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
