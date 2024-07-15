package com.uisrael.acmemoda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {
	
	
	
	// ***** INDEX *****
    @GetMapping("/index")
    public String verIndex() {
        return "/material/index";
    }
    
    
    
    // ***** CLIENTE *****
    @GetMapping("/cliente")
    public String verCliente() {
        return "/material/cliente-lista";
    }
    
    
    
    // ***** PEDIDO ***** 
    @GetMapping("/pedido")
    public String verPedido() {
        return "/material/pedido-lista";
    }
    
    
    
    // ***** CETEGORIA ***** 
    @GetMapping("/categoria")
    public String verCategoria() {
        return "/material/categoria-lista";
    }
    
    
    
    // ***** PRODUCTO ***** 
    @GetMapping("/producto")
    public String verProducto() {
        return "/material/producto-lista";
    }
    
    
    
    // ***** DETALLE *****
    @GetMapping("/detalle")
    public String verDetalle() {
        return "/material/detalle-lista";
    }
    
    

}
