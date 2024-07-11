package com.uisrael.acmemoda.servicio;

import java.util.List;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteServicio 
{
	public List<Cliente> listarCliente();
	
	public void insertarCliente(Cliente nuevoCliente);

	public void actualizarCliente(Cliente editarCliente);
	
	public void eliminarCliente(int idCliente);
	
	public Cliente buscarClienteId(int idCliente);
	
	
	
	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findByApellido(String apellido);
	
	public List<Cliente> buscarPorFecha(int anioInicio, int anioFin);

}
