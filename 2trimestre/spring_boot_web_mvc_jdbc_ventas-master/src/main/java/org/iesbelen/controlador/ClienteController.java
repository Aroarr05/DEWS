package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;

import org.iesbelen.excepcion.MiExcepcion;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping()
	public String listar(Model model) {
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
		return "clientes/clientes";
	}

	@GetMapping("/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);
		return "clientes/detalle-clientes";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "clientes/crear-clientes";
	}

	@PostMapping("/crear")
	public String submitCrear(@Valid @ModelAttribute ("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("cliente", cliente);
			return "clientes/crear-clientes";
		}
		clienteService.newCliente(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/editar/{id}")
	public String editar(Model model,@PathVariable Integer id) {
		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);
		return "clientes/editar-clientes";
	}

	@PostMapping("/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("cliente", cliente);
			return "clientes/editar-clientes";
		}
		clienteService.replaceCliente(cliente);
		return "redirect:/clientes";
	}

	@PostMapping("/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
		return new RedirectView("/clientes");
	}

	@GetMapping("/error-exception")
	public String lanzarMiExcepcion(MiExcepcion ex, Model model){
		model.addAttribute("mensaje", ex.getMessage());
		return "error-exception";

	}

	@GetMapping("/error")
	public String lanzarMiRuntimeException(RuntimeException ex, Model model) {
		model.addAttribute("mensaje", ex.getMessage());
		return "error";
	}
}