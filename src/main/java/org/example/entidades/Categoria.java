package org.example.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@SuperBuilder
public class Categoria extends Base{
    private String denominacion;
    private boolean esInsumo;


    @OneToMany
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriaPadre")
    @JsonIgnoreProperties("categoriaPadre")
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    @JsonIgnoreProperties("subCategorias")
    private Categoria categoriaPadre;

}
