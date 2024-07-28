package org.example.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)

public class Articulo extends Base {

    protected String denominacion;
    protected Double precioVenta;


    @OneToMany
    @JoinColumn(name = "articulo_id")
    @Builder.Default

    protected Set<ImagenArticulo> imagenes = new HashSet<>();

    @ManyToOne
    protected UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
   @JsonIgnoreProperties("articulos")
    private Categoria categoria;


}

