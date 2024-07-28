package org.example.entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity

@SuperBuilder
public class ArticuloManufacturadoDetalle extends Base{
    private Integer cantidad;

    @ManyToOne
    private ArticuloInsumo articuloInsumo;





}
