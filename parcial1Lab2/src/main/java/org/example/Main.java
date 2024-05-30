package org.example;

import org.example.entities.*;
import org.example.entities.enums.Estado;
import org.example.entities.enums.FormaPago;
import org.example.entities.enums.Rol;
import org.example.entities.enums.TipoEnvio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Empleado empleado1 = new Empleado("Juan","Gimenez","261789543","juancito@gmail.com" ,LocalDate.of(2002,4,16), Rol.DELIVERY);
            ImagenEmpleado imagenEmpleado1 = new ImagenEmpleado("imagen empleado 1");
            UsuarioEmpleado usuarioEmpleado1 = new UsuarioEmpleado("pass","userEmployee1");
            Sucursal sucursal1 = new Sucursal("Buen Sabor Godoy Cruz","12:00", LocalTime.of(17,0),true);

            empleado1.setImagenEmpleado(imagenEmpleado1);
            empleado1.setUsuarioEmpleado(usuarioEmpleado1);
            empleado1.setSucursal(sucursal1);

            Cliente cliente1 = new Cliente("Agustin","Fernandez","261452674","agustincito@gmail.com","2001/04/12",Rol.CLIENTE);
            UsuarioCliente usuarioCliente1 = new UsuarioCliente("passss","userClient1");
            ImagenCliente imagenCliente1 = new ImagenCliente("imagen cliente 1");
            Domicilio domicilio1Cliente1 = new Domicilio("Terrada",5505,456);
            Domicilio domicilio2Cliente1 = new Domicilio("Boedo",5505,678);

            cliente1.setUsuarioCliente(usuarioCliente1);
            cliente1.setImagenCliente(imagenCliente1);

            cliente1.getDomicilios().add(domicilio1Cliente1);
            cliente1.getDomicilios().add(domicilio2Cliente1);

            Pedido pedido1 = new Pedido(LocalTime.of(14,30),4000.0,1000.0, Estado.PREPARACION, TipoEnvio.DELIVERY, FormaPago.EFECTIVO,LocalDate.of(2024,5,16));
            pedido1.setEmpleado(empleado1);
            pedido1.setCliente(cliente1);
            pedido1.setDomicilio(domicilio1Cliente1);
            pedido1.setSucursal(sucursal1);

            Factura factura1 = new Factura(LocalDate.of(2024,5,16),45681236,39743282,"202405480-1a3e2f5b-42cd-4e57-8bfc-2e972d67f5c1",FormaPago.EFECTIVO,4000.0);

            pedido1.setFactura(factura1);



            entityManager.persist(empleado1);
            entityManager.persist(cliente1);
            entityManager.persist(pedido1);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        entityManagerFactory.close();


    }
}