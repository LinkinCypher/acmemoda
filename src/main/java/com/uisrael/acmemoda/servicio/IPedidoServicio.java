package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Pedido;

public interface IPedidoServicio 
{
	public List<Pedido> listarPedido();
	
	public void insertarPedido(Pedido nuevoPedido);

	public void actualizarPedido(Pedido editarPedido);
	
	public void eliminarPedido(int idPedido);
	
	public Pedido buscarPedidoId(int idPedido);

}
