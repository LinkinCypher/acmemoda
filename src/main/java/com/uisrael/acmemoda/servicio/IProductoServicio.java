package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Producto;

public interface IProductoServicio {
	public void insertarProducto(Producto nuevoProducto);
	
	public List<Producto> listarProducto();

}
