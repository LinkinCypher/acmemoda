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
    
    

}
