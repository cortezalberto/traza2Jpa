package org.example.entidades;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@SuperBuilder
public class ArticuloManufacturado  extends Articulo{

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;






    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "articuloManufacturado_id")
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();


}
