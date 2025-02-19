package org.iesbelen.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iesbelen.model.Usuario;

import java.io.IOException;

@WebFilter(
        urlPatterns = {"/tienda/usuarios/*"},
        initParams = { @WebInitParam(name = "acceso-concedido-a-rol", value = "administrador")}
)

public class UsuariosFilter  implements Filter {

    private String rolAcceso;

    public UsuariosFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       this.rolAcceso = filterConfig.getInitParameter("acceso-concedido-a-rol");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest =(HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        HttpSession session = httpRequest.getSession();
        String url = httpRequest.getRequestURI().toString();

        Usuario usuarios = null;

        if(session != null
                && (usuarios = (Usuario) session.getAttribute("usuario-logado")) != null
                && rolAcceso.equals(usuarios.getRol())) {
            chain.doFilter(request, response);
        } else if (url.endsWith("/usuarios/crear")
        || url.contains("/usuarios/editar")
        || url.contains("/usuarios/borrar")) {

            httpResponse.sendRedirect(httpRequest.getContextPath() + "/tienda/usuarios/login");
            return;
        }else {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
