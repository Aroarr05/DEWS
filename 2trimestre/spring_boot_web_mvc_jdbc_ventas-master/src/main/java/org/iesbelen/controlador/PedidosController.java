package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.excepcion.MiExcepcion;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.service.ClienteService;
import org.iesbelen.service.ComercialService;
import org.iesbelen.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
    @RequestMapping("/pedidos")
public class PedidosController {
        @Autowired
        private PedidoService pedidoService;
        @Autowired
        private ClienteService clienteService;
        @Autowired
        private ComercialService comercialService;

        @GetMapping("")
        public String listar(Model model) {

            List<PedidoDTO> listaPedidosDTO = pedidoService.listPedidosDTO();
            model.addAttribute("listaPedidos",listaPedidosDTO);
            return "pedidos/pedidos";
        }

        @GetMapping("/{id}")
        public String detalle(Model model, @PathVariable Integer id ) {
            Pedido pedido = pedidoService.one(id);
            Cliente cliente = clienteService.one(id);
            Comercial comercial = comercialService.one(id);
            model.addAttribute("comercial", comercial);
            model.addAttribute("cliente", cliente);
            model.addAttribute("pedido", pedido);
            return "pedidos/detalle-pedidos";
        }

        @GetMapping("/crear")
        public String crear(Model model) {
            Pedido pedido = new Pedido();
            //CREO LA LISTA DE CLIENTES Y COMERCIAL PARA EL SELECT
            List<Cliente> listaClientes = clienteService.listAll();
            List<Comercial> listaComercials = comercialService.listAll();

            model.addAttribute("listaComercials", listaComercials);
            model.addAttribute("listaClientes", listaClientes);
            model.addAttribute("pedido", pedido);
            return "pedidos/crear-pedidos";
        }

        @PostMapping("/crear")
        public String submitCrear(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult bindingResult, Model model) {
            if(bindingResult.hasErrors()){
                model.addAttribute("pedido", pedido);
                return "pedidos/crear-pedidos";
            }
            pedidoService.newPedido(pedido);
            return "redirect:/pedidos";
        }

        @GetMapping("/editar/{id}")
        public String editar(Model model,@PathVariable Integer id) {
            Pedido pedido = pedidoService.one(id);
            model.addAttribute("pedido", pedido);
            return "pedidos/editar-pedidos";
        }

        @PostMapping("/editar/{id}")
        public String submitEditar(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult bindingResult, Model model) {
            if(bindingResult.hasErrors()){
                model.addAttribute("pedido", pedido);
                return "pedidos/editar-pedidos";
            }
            pedidoService.replacePedido(pedido);
            return "redirect:/pedidos";
        }

        @PostMapping("/borrar/{id}")
        public RedirectView submitBorrar(@PathVariable Integer id) {
            pedidoService.deletePedido(id);
            return new RedirectView("/pedidos");
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

