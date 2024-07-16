package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.servicio.IClienteServicio;
import com.uisrael.acmemoda.servicio.IPedidoServicio;

@Controller
public class PedidoControlador {
	
	
	
	// ***** PEDIDO *****
	@Autowired
	public IClienteServicio servicioCliente;
	List<Cliente> listaCliente;

	
	
	// ***** PEDIDO *****
	@Autowired
	public IPedidoServicio servicioPedido;
	
	
	
	// Pagina pedido-registro
	@GetMapping("/nuevopedido")
	public String crearPedidos(Model model) {
		listaCliente = servicioCliente.listarCliente();
		model.addAttribute("nuevoPedido", new Pedido());
		model.addAttribute("listaCliente", listaCliente);
		return "/material/index";
	}
	
	
	
    //Pagina pedido-lista
    @GetMapping("/pedido-listar")
	public String listarPedidos(Model model) { 
    	List<Pedido> listaPedidos = servicioPedido.listarPedido();
    	listaCliente = servicioCliente.listarCliente();
    	model.addAttribute("lista", listaPedidos);
    	model.addAttribute("listaCliente", listaCliente);
		return "/material/pedido-lista";
	}
    
    
    
    //Guardar -> pedido-registro
    @PostMapping("/insertarpedido")
    public String guardarpedido(@ModelAttribute("nuevoPedido") Pedido nuevoPedido) {
    	servicioPedido.insertarPedido(nuevoPedido);
    	return "redirect:/nuevopedido";
    }
    
    
    
    //Editar -> pedido-registro
    @GetMapping("/editarpedido/{idpedido}")
    public String editarPedido(@PathVariable(value="idpedido") int idPedido, Model model) {
    	listaCliente = servicioCliente.listarCliente();
    	Pedido pedidorecuperado = servicioPedido.buscarPedidoId(idPedido);
    	model.addAttribute("nuevoPedido", pedidorecuperado);
    	model.addAttribute("listaCliente", listaCliente);
    	return "/material/pedido-registro";
    }
    
    
    
    //Eliminar -> pedido-lista
    @GetMapping("/eliminarpedido/{idpedido}")
    public String eliminarPedido(@PathVariable(value="idpedido") int idPedido, Model model) {
    	servicioPedido.eliminarPedido(idPedido);
    	return "redirect:/pedido-listar";
    }

    
    
}
