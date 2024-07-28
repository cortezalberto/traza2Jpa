package org.example.entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder

public class ArticuloInsumo extends Articulo {
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

}
