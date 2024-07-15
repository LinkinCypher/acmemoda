package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.servicio.IClienteServicio;

@Controller
public class ClienteControlador {
	
  
	
	
	// ***** INDEX *****
    @GetMapping("/index")
    public String verIndex() {
        return "/material/index";
    }
    
    
    
    
    
	// ***** CLIENTE ***** 
    @Autowired
    public IClienteServicio servicioCliente;
    
    //Nuevo
    @GetMapping("/nuevocliente")
    public String crearClientes(Model model) {
    	model.addAttribute("nuevoCliente", new Cliente()); //cliente-registro
        return "/material/cliente-registro";
    }
    
    //Listar
    @GetMapping("/cliente-listar")
	public String listarClientes(Model model) { 
    	List<Cliente> listaClientes = servicioCliente.listarCliente(); //recuperar información de la BD
    	model.addAttribute("lista", listaClientes);
		return "/material/cliente-lista";  //ruta de la pagina
	}
    
    //Guardar
    @PostMapping("/insertarcliente")
    public String guardarcliente(@ModelAttribute("nuevoCliente") Cliente nuevoCliente) {
    	servicioCliente.insertarCliente(nuevoCliente);
    	return "redirect:/nuevocliente";
    }
    
    //Editar
    @GetMapping("/editarcliente/{idcliente}")
    public String editarCliente(@PathVariable(value="idcliente") int idCliente, Model model) {
    	Cliente clienterecuperado = servicioCliente.buscarClienteId(idCliente);
    	model.addAttribute("nuevoCliente", clienterecuperado);
    	return "/material/cliente-registro";
    }
    
    //Eliminar
    @GetMapping("/eliminarcliente/{idcliente}")
    public String eliminarCliente(@PathVariable(value="idcliente") int idCliente, Model model) {
    	servicioCliente.eliminarCliente(idCliente);
    	return "redirect:/cliente-listar";
    }  
    
    
    
    
    
    // ***** PEDIDO ***** 
    @GetMapping("/pedido")
    public String verPedido() {
        return "/material/pedido";
    }
    
    
    
    
    
    // ***** CETEGORIA ***** 
    @GetMapping("/categoria")
    public String verCategoria() {
        return "/material/categoria";
    }
    
    
    
    
    
    // ***** PRODUCTO ***** 
    @GetMapping("/producto")
    public String verProducto() {
        return "/material/producto";
    }
    
    
    
    
    
    // ***** DETALLE *****
    @GetMapping("/detalle")
    public String verDetalle() {
        return "/material/detalle";
    }
    
    
    
}
