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

	@Override
	public void actualizarCliente(Cliente editarCliente) {
		try {
			clienteRepositorio.save(editarCliente);
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
		}
	}

	@Override
	public void eliminarCliente(int idCliente) {
		try {
			clienteRepositorio.deleteById(idCliente);
		} catch (Exception e) {
			System.out.println("Error al eliminar los datos");
		}
	}

	@Override
	public Cliente buscarClienteId(int idCliente) {
		try {
			return clienteRepositorio.findById(idCliente).get();
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
			return null;
		}
	}
	
	
	@Override
	public List<Cliente> findByNombre(String nombre) {
		try {
            return clienteRepositorio.findByNombre(nombre);
        } catch (Exception e) {
            System.out.println("Error al buscar por nombre");
            return null;
        }
	}

	@Override
	public List<Cliente> findByApellido(String apellido) {
		try {
            return clienteRepositorio.findByApellido(apellido);
        } catch (Exception e) {
            System.out.println("Error al buscar por apellido");
            return null;
        }
	}

	@Override
	public List<Cliente> buscarPorFecha(int anioInicio, int anioFin) {
		try {
            return clienteRepositorio.buscarPorFechas(anioInicio,anioFin);
        } catch (Exception e) {
            System.out.println("Error al buscar por fecha");
            return null;
        }
	}

}
