package com.uisrael.acmemoda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.acmemoda.modelo.Categoria;
import com.uisrael.acmemoda.servicio.ICategoriaServicio;

@Controller
public class CategoriaControlador {
	
	
	
	// ***** CATEGORIA ***** 
    @Autowired
    public ICategoriaServicio servicioCategoria;
    
    
    
    //Pagina categoria-registro
    @GetMapping("/nuevocategoria")
    public String crearCategoria(Model model) {
    	model.addAttribute("nuevoCategoria", new Categoria());
    	return "/material/categoria-registro";
    }
    
    
    
    //Pagina categoria-lista
    @GetMapping("/categoria-listar")
    public String verCategoria(Model model) {
    	List<Categoria> listaCategorias = servicioCategoria.listarCategoria();
    	model.addAttribute("lista", listaCategorias);
        return "/material/categoria-lista";
    }
    
    
    
    //Guardar -> categoria-registro
    @PostMapping("/insertarcategoria")
    public String guardarcategoria(@ModelAttribute("nuevoCategoria") Categoria nuevoCategoria) {
    	servicioCategoria.insertarCategoria(nuevoCategoria);
    	return "redirect:/nuevocategoria";
    }
    
    
    
    //Editar -> categoria-registro
    @GetMapping("/editarcategoria/{idcategoria}")
    public String editarCategoria(@PathVariable(value="idcategoria") int idCategoria, Model model ) {
    	Categoria categoriarecuperado = servicioCategoria.buscarCategoriaId(idCategoria);
    	model.addAttribute("nuevoCategoria", categoriarecuperado);
    	return "/material/categoria-registro";
    }
    
    
    
    //Eliminar -> categoria-lista
    @GetMapping("/eliminarcategoria/{idcategoria}")
    public String eliminarCategoria(@PathVariable(value="idcategoria") int idCategoria, Model model) {
    	servicioCategoria.eliminarCategoria(idCategoria);
    	return "redirect:/categoria-listar";
    }
    
    
    
    
    
    
    
    
    
}
