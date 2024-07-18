package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uisrael.acmemoda.modelo.Categoria;
import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.modelo.Detalle;
import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.modelo.Producto;
import com.uisrael.acmemoda.servicio.ICategoriaServicio;
import com.uisrael.acmemoda.servicio.IClienteServicio;
import com.uisrael.acmemoda.servicio.IDetalleServicio;
import com.uisrael.acmemoda.servicio.IPedidoServicio;
import com.uisrael.acmemoda.servicio.IProductoServicio;

@Controller
public class DetalleControlador {

	
	
	// **** CATEGORIA ****
	@Autowired
	public ICategoriaServicio servicioCategoria;
	List<Categoria> listaCategoria;
	
	
	
	// ***** CLIENTE *****
	@Autowired
	public IClienteServicio servicioCliente;
	List<Cliente> listaCliente;
	
	
	
	// ***** PEDIDO *****
	@Autowired
	public IPedidoServicio servicioPedido;
	List<Pedido> listaPedido;
	
	
	
	// ***** PRODUCTO *****
	@Autowired
	public IProductoServicio servicioProducto;
	List<Producto> listaProducto;
	
	
	
	// ***** DETALLE *****
	@Autowired
	public IDetalleServicio servicioDetalle;
	
	
	
	
	// Pagina detalle-registro
	@GetMapping("/nuevodetalle") 
	public String crearDetalle(Model model) {
		listaCategoria = servicioCategoria.listarCategoria();
        listaCliente = servicioCliente.listarCliente();
        listaPedido = servicioPedido.listarPedido();
        listaProducto = servicioProducto.listarProducto();
        model.addAttribute("nuevoDetalle", new Detalle());
        model.addAttribute("listaCategoria", listaCategoria);
        model.addAttribute("listaCliente", listaCliente);
        model.addAttribute("listaPedido", listaPedido);
        model.addAttribute("listaProducto", listaProducto);
        return "/material/detalle-registro";
	}
	
	
	
	// Página detalle-lista
    @GetMapping("/detalle-listar")
    public String listarDetalles(Model model) {
        List<Detalle> listaDetalles = servicioDetalle.listarDetalle();
        listaCategoria = servicioCategoria.listarCategoria();
        listaCliente = servicioCliente.listarCliente();
        listaPedido = servicioPedido.listarPedido();
        listaProducto = servicioProducto.listarProducto();
        model.addAttribute("lista", listaDetalles);
        model.addAttribute("listaCategoria", listaCategoria);
        model.addAttribute("listaCliente", listaCliente);
        model.addAttribute("listaPedido", listaPedido);
        model.addAttribute("listaProducto", listaProducto);
        return "/material/detalle-lista";
    }

    // Guardar -> detalle-registro
    @PostMapping("/insertardetalle")
    public String guardarDetalle(@ModelAttribute("nuevoDetalle") Detalle nuevoDetalle) {
        servicioDetalle.insertarDetalle(nuevoDetalle);
        return "redirect:/detalle-listar";
    }

    
    
    // Editar -> detalle-registro
    @GetMapping("/editardetalle/{iddetalle}")
    public String editarDetalle(@PathVariable(value = "iddetalle") int idDetalle, Model model) {
        listaCategoria = servicioCategoria.listarCategoria();
        listaCliente = servicioCliente.listarCliente();
        listaPedido = servicioPedido.listarPedido();
        listaProducto = servicioProducto.listarProducto();
        Detalle detallerecuperado = servicioDetalle.buscarDetalleId(idDetalle);
        model.addAttribute("nuevoDetalle", detallerecuperado);
        model.addAttribute("listaCategoria", listaCategoria);
        model.addAttribute("listaCliente", listaCliente);
        model.addAttribute("listaPedido", listaPedido);
        model.addAttribute("listaProducto", listaProducto);
        return "/material/detalle-registro";
    }

    
    
    // Eliminar -> detalle-lista
    @GetMapping("/eliminardetalle/{iddetalle}")
    public String eliminarDetalle(@PathVariable(value = "iddetalle") int idDetalle, Model model) {
        servicioDetalle.eliminarDetalle(idDetalle);
        return "redirect:/detalle-listar";
    }
    
    
    
    @GetMapping("/pedidosPorCliente/{idCliente}")
    @ResponseBody
    public List<Pedido> obtenerPedidosPorCliente(@PathVariable int idCliente) {
        return servicioPedido.buscarPedidosPorClienteId(idCliente);
    }
    
    
    
    @GetMapping("/productosPorCategoria/{idCategoria}")
    @ResponseBody
    public List<Producto> obtenerProductosPorCategoria(@PathVariable int idCategoria) {
        return servicioProducto.buscarProductosPorCategoriaId(idCategoria);
    }
}