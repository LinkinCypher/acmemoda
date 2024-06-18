package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Pedido;

public interface IPedidoServicio {
	public void insertarPedido(Pedido nuevoPedido);

	public List<Pedido> listartPedidos();

}
