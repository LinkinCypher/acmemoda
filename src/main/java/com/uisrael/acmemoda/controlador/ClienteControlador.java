package com.uisrael.acmemoda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControlador {
	
	@GetMapping("/cliente")
	public String crearCursos() {
		return "/material/cliente";
	}
	
	@GetMapping("/auth-normal-sign-in")
    public String showLoginPage() {
        return "/material/auth-normal-sign-in"; // Thymeleaf buscará auth-normal-sign-in en src/main/resources/templates
    }

    @GetMapping("/auth-sign-up")
    public String showRegistrationPage() {
        return "/material/auth-sign-up"; // Thymeleaf buscará auth-sign-up en src/main/resources/templates
    }
    
    @GetMapping("/index")
    public String showIndexPage() {
        return "/material/index"; // Thymeleaf buscará index en src/main/resources/templates
    }

}
