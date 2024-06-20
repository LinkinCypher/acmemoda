package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteServicio 
{
	public void insertarCliente(Cliente nuevoCliente);

	public List<Cliente> listarCliente();
	
	public Cliente buscarClienteId(String cedula);
	
	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findByApellido(String apellido);
	
	public List<Cliente> buscarPorFecha(int anioInicio, int anioFin);

}
