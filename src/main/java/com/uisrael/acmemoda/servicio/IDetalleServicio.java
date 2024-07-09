package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Detalle;

public interface IDetalleServicio {
	public void insertarDetalle(Detalle nuevoDetalle);
	
	public List<Detalle> listarDetalle();

}
