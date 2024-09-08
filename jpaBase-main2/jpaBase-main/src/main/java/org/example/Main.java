package org.example;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {

            entityManager.getTransaction().begin();

            Articulo articulo1 = Articulo.builder().denominacion("hojas").cantidad(200).precio(150).build();
            Categoria categoria1 = Categoria.builder().denominacion("Utiles escolares").build();

            articulo1.getCategorias().add(categoria1);
            categoria1.getArticulos().add(articulo1);

            Factura factura1 = Factura.builder().fecha("13/06/2022").numero(1234).build();
            DetalleFactura detalle1 = DetalleFactura.builder().articulo(articulo1).cantidad(3).build();

            factura1.getDetalles().add(detalle1);

            Domicilio domicilio1 = Domicilio.builder().nombreCalle("Roca").numero(234).build();
            Cliente cliente1 = Cliente.builder().nombre("Pepe").apellido("Romeo").dni(22222222).domicilio(domicilio1).build();

            factura1.setCliente(cliente1);

            entityManager.persist(factura1);
            entityManager.getTransaction().commit();




        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
