package org.iesbelen.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String dni;
    private String nombre;
    private String apellido;

    @ElementCollection
    @CollectionTable(name="socio_addresses", joinColumns = @JoinColumn(name = "socio_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name ="house_number")),
            @AttributeOverride(name = "street" , column = @Column(name ="street")),
            @AttributeOverride(name = "city" , column = @Column(name ="city")),
            @AttributeOverride(name = "zipCode" , column = @Column(name ="zip_code")),
    })
    private Set<Address> addresses = new HashSet<>();

    @Embedded // 4.6
    private Address mainAddress; // 4.6

    @ElementCollection
    @CollectionTable(name = "socio_phone_numbers", joinColumns = @JoinColumn(name = "socio_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;


    //Relacion de uno a uno con la tarjeta
    @OneToOne
    @JoinColumn(name="tarjeta_id", referencedColumnName = "id")
    private Tarjeta tarjeta;



}
