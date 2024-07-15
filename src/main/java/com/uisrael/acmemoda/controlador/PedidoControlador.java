package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.servicio.IPedidoServicio;

@Controller
public class PedidoControlador {
	
	
	
	// ***** PEDIDO *****
	@Autowired
	public IPedidoServicio servicioPedido;
	
	
	
	// Pagina pedido-registro
	@GetMapping("/nuevopedido")
	public String crearPedidos(Model model) {
		model.addAttribute("nuevoPedido", new Pedido());
		return "/material/pedido-registro";
	}
	
	
	
    //Pagina pedido-lista
    @GetMapping("/pedido-listar")
	public String listarPedidos(Model model) { 
    	List<Pedido> listaPedidos = servicioPedido.listarPedido();
    	model.addAttribute("lista", listaPedidos);
		return "/material/cliente-lista";
	}
    
    
    
    //GUardar -> pedido-registro
    @PostMapping("/insertarpedido")
    public String guardarpedido(@ModelAttribute("nuevoPedido") Pedido nuevoPedido) {
    	servicioPedido.insertarPedido(nuevoPedido);
    	return "redirect:/nuevopedido";
    }
    
    
    
    //Editar -> pedido-registro
    @GetMapping("/editarpedido/{idpedido}")
    public String editarPedido(@PathVariable(value="idpedido") int idPedido, Model model) {
    	Pedido pedidorecuperado = servicioPedido.buscarPedidoId(idPedido);
    	model.addAttribute("nuevoPedido", pedidorecuperado);
    	return "/material/pedido-registro";
    }
    
    
    
    //Eliminar -> pedido-lista
    @GetMapping("/eliminarpedido/{idpedido}")
    public String eliminarPedido(@PathVariable(value="idpedido") int idPedido, Model model) {
    	servicioPedido.eliminarPedido(idPedido);
    	return "redirect:/pedido-listar";
    }

    
    
}
