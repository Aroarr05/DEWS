package org.iesbelen.modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.iesbelen.validador.RangoCategoria;
import org.iesbelen.validador.RangoCategoriaPlus;


@Data
@AllArgsConstructor
public class Cliente {

	private long id;
	@NotBlank(message = "{error.nombre}")
	@Size(max=30, message = "{error.maximo.30}")
	private String nombre;
	@NotBlank(message = "{error.apellido}")
	@Size(max=30, message = "{error.maximo.30}")
	private String apellido1;
	private String apellido2;
	@NotBlank(message = "{error.ciudad}")
	@Size(max=50, message = "{error.maximo.50}")
	private String ciudad;
	@Min(value = 100, message = "{min.categoria}")
	@Max(value = 1000, message = "{max.categoria}")
	@RangoCategoria
	@RangoCategoriaPlus(value = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000})
	private int categoria;

	//@Email(message = "{error.correo}", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	//	//@NotBlank(message = "Por favor, introduzca email.")
	//	private String email;

	public Cliente() {
		super();
	}

}
