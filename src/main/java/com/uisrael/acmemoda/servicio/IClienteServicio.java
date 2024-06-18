package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteServicio {
	public void insertarCliente(Cliente nuevoCliente);

	public List<Cliente> listarCliente();

}
