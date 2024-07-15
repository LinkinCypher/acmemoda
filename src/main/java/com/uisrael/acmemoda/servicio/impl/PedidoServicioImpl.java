package com.uisrael.acmemoda.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.repositorio.IPedidoRepositorio;
import com.uisrael.acmemoda.servicio.IPedidoServicio;

@Service
@Component
public class PedidoServicioImpl implements IPedidoServicio{

	@Autowired
	IPedidoRepositorio pedidoRepositorio;
	
	@Override
	public void insertarPedido(Pedido nuevoPedido) {
		try {
			pedidoRepositorio.save(nuevoPedido);
		} catch (Exception e) {
			System.out.println("Error al ingresar datos");
		}
	}

	@Override
	public List<Pedido> listartPedidos() {
		try {
			return pedidoRepositorio.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los datos");
			return null;
		}
	}

	@Override
	public void actualizarPedido(Pedido editarPedido) {
		try {
			pedidoRepositorio.save(editarPedido);
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
		}
	}

	@Override
	public void eliminarPedido(int idPedido) {
		try {
			pedidoRepositorio.deleteById(idPedido);
		} catch (Exception e) {
			System.out.println("Error al eliminar los datos");
		}
	}

	@Override
	public Pedido buscarPedidoId(int idPedido) {
		try {
			return pedidoRepositorio.findById(idPedido).get();
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
			return null;
		}
	}
}
