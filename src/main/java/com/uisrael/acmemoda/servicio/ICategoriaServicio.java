package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Categoria;

public interface ICategoriaServicio 
{
	public List<Categoria> listarCategoria();
	
	public void insertarCategoria(Categoria nuevoCategoria);

	public void actualizarCategoria(Categoria editarCategoria);
	
	public void eliminarCategoria(int idCategoria);
	
	public Categoria buscarCategoriaId(int idCategoria);

}
