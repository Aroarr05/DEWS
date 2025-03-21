package org.iesbelen.videoclub.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tarjetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date caducidad;
    @OneToOne(mappedBy = "tarjeta")
    @JsonIgnore
    private Socio socio;

}
