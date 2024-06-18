package com.uisrael.acmemoda.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.repositorio.IClienteRepositorio;
import com.uisrael.acmemoda.servicio.IClienteServicio;

@Service
@Component
public class ClienteServicioImpl implements IClienteServicio {

	@Autowired
	IClienteRepositorio clienteRepositorio;

	@Override
	public void insertarCliente(Cliente nuevoCliente) {
		try {
			clienteRepositorio.save(nuevoCliente);
		} catch (Exception e) {
			System.out.println("Error al ingresar datos");
		}

	}

	@Override
	public List<Cliente> listarCliente() {
		try {
			return clienteRepositorio.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los datos");
			return null;
		}
	}

}
