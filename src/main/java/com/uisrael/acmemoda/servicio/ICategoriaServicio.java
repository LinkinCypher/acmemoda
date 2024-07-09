package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Categoria;

public interface ICategoriaServicio {
	public void insertarCategoria(Categoria nuevoCategoria);
	
	public List<Categoria> listarCategoria();

}
