package com.uisrael.acmemoda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControlador {
	
	@GetMapping("/ingreso")
    public String verLogin() {
        return "/material/ingreso"; // Thymeleaf buscará auth-normal-sign-in en src/main/resources/templates
    }

    @GetMapping("/registro")
    public String verRegistro() {
        return "/material/registro"; // Thymeleaf buscará auth-sign-up en src/main/resources/templates
    }
    
    @GetMapping("/index")
    public String verIndex() {
        return "/material/index"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    @GetMapping("/usuario")
	public String verCliente() { 
		return "/material/usuario";  // Thymeleaf buscará index en src/main/resources/templates
	}
    
    @GetMapping("/pedido")
    public String verPedido() {
        return "/material/pedido"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    @GetMapping("/detallePedido")
    public String verDetallePedido() {
        return "/material/detallePedido"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    @GetMapping("/categoria")
    public String verCategoria() {
        return "/material/categoria"; // Thymeleaf buscará index en src/main/resources/templates
    }
    
    @GetMapping("/producto")
    public String verProducto() {
        return "/material/producto"; // Thymeleaf buscará index en src/main/resources/templates
    }

}
