package com.uisrael.acmemoda.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.acmemoda.modelo.Detalle;
import com.uisrael.acmemoda.repositorio.IDetalleRepositorio;
import com.uisrael.acmemoda.servicio.IDetalleServicio;

@Service
@Component
public class DetalleServicioImpl implements IDetalleServicio{

	@Autowired
	IDetalleRepositorio detalleRepositorio;
	
	@Override
	public void insertarDetalle(Detalle nuevoDetalle) {
		try {
			detalleRepositorio.save(nuevoDetalle);
		} catch (Exception e) {
			System.out.println("Error al ingresar datos");
		}
	}

	@Override
	public List<Detalle> listarDetalle() {
		try {
			return detalleRepositorio.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los datos");
			return null;
		}
	}

	@Override
	public void actualizarDetalle(Detalle editarDetalle) {
		try {
			detalleRepositorio.save(editarDetalle);
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
		}
	}

	@Override
	public void eliminarDetalle(int idDetalle) {
		try {
			detalleRepositorio.deleteById(idDetalle);
		} catch (Exception e) {
			System.out.println("Error al eliminar los datos");
		}
	}

	@Override
	public Detalle buscarDetalleId(int idDetalle) {
		try {
			return detalleRepositorio.findById(idDetalle).get();
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
			return null;
		}
	}
}
