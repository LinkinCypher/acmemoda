package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.servicio.IClienteServicio;

@Controller
public class ClienteControlador {
	
  
	
	// CLIENTE
    @Autowired
    public IClienteServicio servicioCliente;
    
    @GetMapping("/registro")
    public String crearCliente(Model model) {
    	model.addAttribute("nuevoCliente", new Cliente()); //registro
        return "/material/registro";
    }
    
    
    @GetMapping("/listarclientes")
	public String listarClientes(Model model) { 
    	List<Cliente> listaClientes = servicioCliente.listarCliente(); //recuperar información de la BD
    	model.addAttribute("lista", listaClientes);
		return "/material/listacliente";  //ruta de la pagina
	}
    
    @PostMapping("/insertarcliente")
    public String guardarcliente(@ModelAttribute("nuevoCliente") Cliente nuevoCliente) {
    	servicioCliente.insertarCliente(nuevoCliente);
    	return "redirect:/listarclientes";
    }
    
    

    
    
    
    
    
    
    
    
    
    // PEDIDO
    @GetMapping("/pedido")
    public String verPedido() {
        return "/material/pedido";
    }
    
    
    // DETALLE
    @GetMapping("/detalle")
    public String verDetalle() {
        return "/material/detalle";
    }
    
    
    
    // CETEGORIA
    @GetMapping("/categoria")
    public String verCategoria() {
        return "/material/categoria";
    }
    
    
    
    // PRODUCTO
    @GetMapping("/producto")
    public String verProducto() {
        return "/material/producto";
    }
    
    
    
}
