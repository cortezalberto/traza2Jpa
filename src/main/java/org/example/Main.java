package org.example;

import org.example.entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            // Crear categorías
            Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
            Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
            Categoria bebidas = Categoria.builder().denominacion("Bebidas").esInsumo(false).build();
            Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();

            entityManager.persist(pizzas);
            entityManager.persist(sandwiches);
            entityManager.persist(bebidas);
            entityManager.persist(insumos);

            // Crear unidades de medida
            UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
            UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
            UnidadMedida gramos = UnidadMedida.builder().denominacion("Gramos").build();

            entityManager.persist(kg);
            entityManager.persist(litro);
            entityManager.persist(gramos);

            // Crear artículos insumos
            ArticuloInsumo sal = ArticuloInsumo.builder()
                    .denominacion("Sal")
                    .precioCompra(1.0)
                    .stockActual(100)
                    .stockMinimo(10)
                    .stockMaximo(200)
                    .esParaElaborar(true)
                    .unidadMedida(gramos)
                    .categoria(insumos)
                    .build();

            ArticuloInsumo harina = ArticuloInsumo.builder()
                    .denominacion("Harina")
                    .precioCompra(0.5)
                    .stockActual(50)
                    .stockMinimo(5)
                    .stockMaximo(100)
                    .esParaElaborar(true)
                    .unidadMedida(kg)
                    .categoria(insumos)
                    .build();

            ArticuloInsumo aceite = ArticuloInsumo.builder()
                    .denominacion("Aceite")
                    .precioCompra(3.0)
                    .stockActual(30)
                    .stockMinimo(3)
                    .stockMaximo(60)
                    .esParaElaborar(true)
                    .unidadMedida(litro)
                    .categoria(insumos)
                    .build();

            ArticuloInsumo carne = ArticuloInsumo.builder()
                    .denominacion("Carne")
                    .precioCompra(5.0)
                    .stockActual(20)
                    .stockMinimo(2)
                    .stockMaximo(40)
                    .esParaElaborar(true)
                    .unidadMedida(kg)
                    .categoria(insumos)
                    .build();

            entityManager.persist(sal);
            entityManager.persist(harina);
            entityManager.persist(aceite);
            entityManager.persist(carne);


            System.out.println("Persistí los insumos ----------------------------------");

            // Crear imágenes para los artículos
            ImagenArticulo img1 = ImagenArticulo.builder().name("Pizza1").url("http://example.com/pizza1").build();
            ImagenArticulo img2 = ImagenArticulo.builder().name("Pizza2").url("http://example.com/pizza2").build();
            ImagenArticulo img3 = ImagenArticulo.builder().name("Pizza3").url("http://example.com/pizza3").build();
            ImagenArticulo img4 = ImagenArticulo.builder().name("Lomo1").url("http://example.com/lomo1").build();
            ImagenArticulo img5 = ImagenArticulo.builder().name("Lomo2").url("http://example.com/lomo2").build();
            ImagenArticulo img6 = ImagenArticulo.builder().name("Lomo3").url("http://example.com/lomo3").build();

            // Crear detalles de artículos manufacturados
            ArticuloManufacturadoDetalle detallePizzaHawaina1 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(1)
                    .articuloInsumo(sal)
                    .build();

            ArticuloManufacturadoDetalle detallePizzaHawaina2 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(2)
                    .articuloInsumo(harina)
                    .build();

            ArticuloManufacturadoDetalle detallePizzaHawaina3 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(1)
                    .articuloInsumo(aceite)
                    .build();

            ArticuloManufacturadoDetalle detalleLomoCompleto1 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(1)
                    .articuloInsumo(sal)
                    .build();

            ArticuloManufacturadoDetalle detalleLomoCompleto2 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(1)
                    .articuloInsumo(aceite)
                    .build();

            ArticuloManufacturadoDetalle detalleLomoCompleto3 = ArticuloManufacturadoDetalle.builder()
                    .cantidad(2)
                    .articuloInsumo(carne)
                    .build();

            // Crear artículos manufacturados
            ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                    .denominacion("Pizza Hawaina")
                    .precioVenta(12.0)
                    .descripcion("Pizza con piña y jamón")
                    .tiempoEstimadoMinutos(20)
                    .preparacion("Hornear por 20 minutos")
                    .categoria(pizzas)
                    .unidadMedida(kg)
       //             .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                    .articuloManufacturadoDetalles(new HashSet<>(Set.of(detallePizzaHawaina1, detallePizzaHawaina2, detallePizzaHawaina3)))
                    .build();

            ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                    .denominacion("Lomo Completo")
                    .precioVenta(15.0)
                    .descripcion("Lomo completo con todos los ingredientes")
                    .tiempoEstimadoMinutos(25)
                    .preparacion("Cocinar a la parrilla por 25 minutos")
                    .categoria(sandwiches)
                    .unidadMedida(kg)
            //        .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                    .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalleLomoCompleto1, detalleLomoCompleto2, detalleLomoCompleto3)))
                    .build();

            entityManager.persist(pizzaHawaina);
            entityManager.persist(lomoCompleto);



            entityManager.getTransaction().commit();


        }catch (Exception e){

            entityManager.getTransaction().rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");}

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
