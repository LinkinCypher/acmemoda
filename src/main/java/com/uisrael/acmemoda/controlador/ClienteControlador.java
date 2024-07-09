package com.uisrael.acmemoda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControlador {
	
	// INGRESO
	@GetMapping("/ingreso")
    public String verLogin() {
        return "/material/ingreso"; // Thymeleaf buscará auth-normal-sign-in en src/main/resources/templates
    }
	
	
	
	// INDEX - DASHBOARD
    @GetMapping("/index")
    public String verIndex() {
        return "/material/index"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    
	//REGISTRO CLIENTE
    @GetMapping("/registro")
    public String verRegistro() {
        return "/material/registro"; // Thymeleaf buscará auth-sign-up en src/main/resources/templates
    }
    
    

    // CLIENTE - LISTAR
    @GetMapping("/cliente")
	public String verCliente() { 
		return "/material/cliente";  // Thymeleaf buscará index en src/main/resources/templates
	}
    
    
    
    // PEDIDO
    @GetMapping("/pedido")
    public String verPedido() {
        return "/material/pedido"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    // DETALLE
    @GetMapping("/detalle")
    public String verDetalle() {
        return "/material/detalle"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    
    // CETEGORIA
    @GetMapping("/categoria")
    public String verCategoria() {
        return "/material/categoria"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    
    // PRODUCTO
    @GetMapping("/producto")
    public String verProducto() {
        return "/material/producto"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    
    
}
