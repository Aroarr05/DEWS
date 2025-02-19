package org.iesbelen.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Comercial {

	private int id;
	@NotBlank(message = "{error.nombre}")
	@Size(max=30, message = "{error.maximo.30}")
	private String nombre;
	@NotBlank(message = "{error.apellido}")
	@Size(max=30, message = "{error.maximo.30}")
	private String apellido1;
	private String apellido2;
	@DecimalMin(value = "0.276",message="{decimal.min}")
	@DecimalMax(value = "0.946",message = "{decimal.max}")
	private BigDecimal comision;

	public Comercial() {
		super();
	}


}
