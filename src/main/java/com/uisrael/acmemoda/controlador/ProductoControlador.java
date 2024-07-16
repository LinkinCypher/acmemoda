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
import com.uisrael.acmemoda.modelo.Producto;
import com.uisrael.acmemoda.servicio.ICategoriaServicio;
import com.uisrael.acmemoda.servicio.IProductoServicio;

@Controller
public class ProductoControlador {
	
	
	
	// ***** CATEGORIA *****
	@Autowired
	public ICategoriaServicio servicioCategoria;
	List<Categoria> listaCategoria;
	
	
	
	// ***** PRODUCTO *****
	@Autowired
	public IProductoServicio servicioProducto;

	
	
	// Pagina producto-registro
	@GetMapping("/nuevoproducto")
	public String crearProducto(Model model) {
		listaCategoria = servicioCategoria.listarCategoria();
		model.addAttribute("nuevoProducto", new Producto());
		model.addAttribute("listaCategoria", listaCategoria);
		return "/material/producto-registro";
	}
	
	
	
	
	 //Pagina producto-lista
    @GetMapping("/producto-listar")
	public String listarProducto(Model model) { 
    	List<Producto> listaProducto = servicioProducto.listarProducto();
    	listaCategoria = servicioCategoria.listarCategoria();
    	model.addAttribute("lista", listaProducto);
    	model.addAttribute("listaCategoria", listaCategoria);
		return "/material/producto-lista";
	}
    
    
    
  //Guardar -> producto-registro
    @PostMapping("/insertarproducto")
    public String guardarproducto(@ModelAttribute("nuevoProducto") Producto nuevoProducto) {
    	servicioProducto.insertarProducto(nuevoProducto);
    	return "redirect:/nuevoproducto";
    }
    
    
    
    //Editar -> producto-registro
    @GetMapping("/editarproducto/{idproducto}")
    public String editarProducto(@PathVariable(value="idproducto") int idProducto, Model model) {
    	listaCategoria = servicioCategoria.listarCategoria();
    	Producto productorecuperado = servicioProducto.buscarProductoId(idProducto);
    	model.addAttribute("nuevoProducto", productorecuperado);
    	model.addAttribute("listaCategoria", listaCategoria);
    	return "/material/producto-registro";
    }
    
    
    
  //Eliminar -> pedido-lista
    @GetMapping("/eliminarproducto/{idproducto}")
    public String eliminarProducto(@PathVariable(value="idproducto") int idProducto, Model model) {
    	servicioProducto.eliminarProducto(idProducto);
    	return "redirect:/producto-listar";
    }

    

}
