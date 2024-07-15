package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Detalle;

public interface IDetalleServicio 
{
	public List<Detalle> listarDetalle();
	
	public void insertarDetalle(Detalle nuevoDetalle);

	public void actualizarDetalle(Detalle editarDetalle);
	
	public void eliminarDetalle(int idDetalle);
	
	public Detalle buscarDetalleId(int idDetalle);

}
