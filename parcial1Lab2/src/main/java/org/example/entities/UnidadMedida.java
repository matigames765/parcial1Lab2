package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidades_de_medidas")
public class UnidadMedida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;
}
