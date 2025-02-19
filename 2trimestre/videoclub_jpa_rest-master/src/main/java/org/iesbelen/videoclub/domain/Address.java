package org.iesbelen.videoclub.domain;

import jakarta.persistence.Embeddable;
import jdk.jfr.Name;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

//No se usa @ENTITY, es un embeddable
@Embeddable
public class Address {
    private int id;
    private String street;
    private String houseNumber;
    private String city;
    private int zipCode;
}
