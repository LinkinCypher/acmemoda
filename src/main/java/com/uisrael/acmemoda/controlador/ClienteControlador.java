package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.servicio.IClienteServicio;

@Controller
public class ClienteControlador {
	
	// INGRESO
	@GetMapping("/ingreso")
    public String verLogin() {
        return "/material/ingreso";
    }
	
	
	
	// INDEX - DASHBOARD
    @GetMapping("/index")
    public String verIndex() {
        return "/material/index"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    
	//REGISTRO CLIENTE
    @GetMapping("/registro")
    public String verRegistro() {
        return "/material/registro";
    }
    
    

    // CLIENTE - LISTAR
    @Autowired
    public IClienteServicio servicioCliente;
    
    @GetMapping("/cliente")
	public String verCliente(Model model) { 
    	List<Cliente> verCliente = servicioCliente.listarCliente(); //recuperar información de la BD
    	model.addAttribute("lista", verCliente);
		return "/material/cliente";
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
