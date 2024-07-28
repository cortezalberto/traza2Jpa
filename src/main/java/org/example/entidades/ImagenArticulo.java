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
public class ImagenArticulo extends Base{

    private String name;
    private String url;

}
