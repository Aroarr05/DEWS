package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.FabricanteDAO;
import org.iesbelen.dao.FabricanteDAOImpl;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Fabricante;
import org.iesbelen.model.FabricanteDTO;
import org.iesbelen.model.Producto;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productosServlet", value = "/tienda/productos/*")
public class ProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/productos/
	 * 		/productos/{id}
	 * 		/productos/editar{id}
	 * 		/productos/crear
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			ProductoDAO fabDAO = new ProductoDAOImpl();
			
			//GET 
			//	/productos/
			//	/productos



			request.setAttribute("listaProductos", fabDAO.getAll());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");

			String nombre = request.getParameter("filtrar-por-nombre");

			if (nombre != null && !nombre.isEmpty()) {
				request.setAttribute("listaProductos", fabDAO.filtro(nombre));
				System.out.println(nombre);
			}else {
				request.setAttribute("listaProductos", fabDAO.getAll());
			}


		} else {
			// GET
			// 		/productos/{id}
			// 		/productos/{id}/
			// 		/productos/edit/{id}
			// 		/productos/edit/{id}/
			// 		/productos/crear
			// 		/productos/crear/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

				FabricanteDAO fabDAO = new FabricanteDAOImpl();
				List<Fabricante> listaFabricantes = fabDAO.getAll();
				List<FabricanteDTO> fabricanteDTOS = listaFabricantes.stream()
						.map(fabricante -> new FabricanteDTO(fabricante, fabDAO.getCountProductos(fabricante.getIdFabricante()).orElse(0)))
						.toList();

				request.setAttribute("listaFabricantes", fabricanteDTOS);
				// GET
				// /productos/crear
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/crear-producto.jsp");
        												
			
			} else if (pathParts.length == 2) {
				ProductoDAO fabDAO = new ProductoDAOImpl();
				// GET
				// /productos/{id}
				try {

					request.setAttribute("producto",fabDAO.find(Integer.parseInt(pathParts[1])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp//productos/detalle-producto.jsp");

				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
				}
				
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				ProductoDAO fabDAO = new ProductoDAOImpl();
				
				// GET
				// /productos/editar/{id}
				try {
					request.setAttribute("producto",fabDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp//productos/editar-producto.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productos/productos.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		System.out.println(__method__);
		if (__method__ == null) {
			// Crear uno nuevo
			ProductoDAO prodDAO = new ProductoDAOImpl();
			
			String nombre = request.getParameter("nombre");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			Integer idFabricante = Integer.parseInt(request.getParameter("fab"));
			Producto nuevoProd = new Producto();

			nuevoProd.setNombre(nombre);
			nuevoProd.setPrecio(precio);
			nuevoProd.setCodigo_fabricante(idFabricante);
			prodDAO.create(nuevoProd);
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);

		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);

		} else {
			System.out.println("Opción POST no soportada.");
		}

		//response.sendRedirect("../../../tienda/productos");
		response.sendRedirect(request.getContextPath() + "/tienda/productos");
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductoDAO prodDAO = new ProductoDAOImpl();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		Producto fab = new Producto();
		
		try {
			
			int id = Integer.parseInt(codigo);
			fab.setIdProducto(id);
			fab.setNombre(nombre);
			fab.setPrecio(precio);
			prodDAO.update(fab);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	{
		RequestDispatcher dispatcher;
		ProductoDAO prodDAO = new ProductoDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			
			int id = Integer.parseInt(codigo);
		
		prodDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}
}
