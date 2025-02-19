package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.dto.ComercialDetalleDTO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.excepcion.MiExcepcion;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.iesbelen.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/comerciales")
public class ComercialController {

    private final ComercialService comercialService;
    private final PedidoService pedidoService;

    public ComercialController(ComercialService comercialService, PedidoService pedidoService) {
        this.comercialService = comercialService;
        this.pedidoService = pedidoService;
    }


    @GetMapping()
    public String listar(Model model) {
        List<Comercial> listaComercial = comercialService.listAll();
        model.addAttribute("listaComercial", listaComercial);
        return "comerciales/comerciales";
    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {
        ComercialDetalleDTO comercial = comercialService.detalleComercial(id);

       // List<PedidoDTO> pedidoDTO = pedidoService.listPedidosDTO(id);

        ComercialDetalleDTO comercialDetalle = comercialService.detalleComercial(id);

        model.addAttribute("comercial", comercial);
      //  model.addAttribute("pedidoDTO",pedidoDTO);
        model.addAttribute("comercialDetalle", comercialDetalle);

        return "comerciales/detalle-comerciales";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);
        return "comerciales/crear-comerciales";
    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("comercial", comercial);
            return "comerciales/crear-comerciales";
        }
        comercialService.newComercial(comercial);
        return "redirect:/comerciales" ;
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {
        Comercial comercial = comercialService.one(id);
        model.addAttribute("comercial", comercial);
        return "comerciales/editar-comerciales";
    }

    @PostMapping("/editar/{id}")
    public String submitEditar(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("comercial", comercial);
            return "comerciales/editar-comerciales";
        }
        comercialService.replaceComercial(comercial);
        return "redirect:/comerciales";
    }

    @PostMapping("/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {
        comercialService.deleteComercial(id);
        return new RedirectView("/comerciales");
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
