package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Producto;

public interface IProductoServicio 
{
	public List<Producto> listarProducto();
	
	public void insertarProducto(Producto nuevoProducto);

	public void actualizarProducto(Producto editarProducto);
	
	public void eliminarProducto(int idProducto);
	
	public Producto buscarProductoId(int idProducto);

}
