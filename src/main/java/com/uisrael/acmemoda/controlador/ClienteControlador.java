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
import com.uisrael.acmemoda.servicio.IClienteServicio;

@Controller
public class ClienteControlador {
	

	
	// ***** CLIENTE ***** 
    @Autowired
    public IClienteServicio servicioCliente;
    
    
    
    //Pagina cliente-registro
    @GetMapping("/nuevocliente")
    public String crearClientes(Model model) {
    	model.addAttribute("nuevoCliente", new Cliente());
        return "/material/cliente-registro";
    }
    
    
    
    //Pagina cliente-lista
    @GetMapping("/cliente-listar")
	public String listarClientes(Model model) { 
    	List<Cliente> listaClientes = servicioCliente.listarCliente();
    	model.addAttribute("lista", listaClientes);
		return "/material/cliente-lista";
	}
    
    
    
    //Guardar -> cliente-registro
    @PostMapping("/insertarcliente")
    public String guardarcliente(@ModelAttribute("nuevoCliente") Cliente nuevoCliente) {
    	servicioCliente.insertarCliente(nuevoCliente);
    	return "redirect:/nuevocliente";
    }
    
    
    
    //Editar -> cliente-regitro
    @GetMapping("/editarcliente/{idcliente}")
    public String editarCliente(@PathVariable(value="idcliente") int idCliente, Model model) {
    	Cliente clienterecuperado = servicioCliente.buscarClienteId(idCliente);
    	model.addAttribute("nuevoCliente", clienterecuperado);
    	return "/material/cliente-registro";
    }
    
    
    
    //Eliminar -> cliente-lista
    @GetMapping("/eliminarcliente/{idcliente}")
    public String eliminarCliente(@PathVariable(value="idcliente") int idCliente, Model model) {
    	servicioCliente.eliminarCliente(idCliente);
    	return "redirect:/cliente-listar";
    }  
    
    
    
}
