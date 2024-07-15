package com.uisrael.acmemoda.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.acmemoda.modelo.Categoria;
import com.uisrael.acmemoda.repositorio.ICategoriaRepositorio;
import com.uisrael.acmemoda.servicio.ICategoriaServicio;

@Service
@Component
public class CategoriaServicioImpl implements ICategoriaServicio{

	@Autowired
	ICategoriaRepositorio categoriaRepositorio;
	
	@Override
	public void insertarCategoria(Categoria nuevoCategoria) {
		try {
			categoriaRepositorio.save(nuevoCategoria);
		} catch (Exception e) {
			System.out.println("Error al ingresar datos");
		}
	}

	@Override
	public List<Categoria> listarCategoria() {
		try {
			return categoriaRepositorio.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los datos");
			return null;
		}
	}

	@Override
	public void actualizarCategoria(Categoria editarCategoria) {
		try {
			categoriaRepositorio.save(editarCategoria);
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
		}
	}

	@Override
	public void eliminarCategoria(int idCategoria) {
		try {
			categoriaRepositorio.deleteById(idCategoria);
		} catch (Exception e) {
			System.out.println("Error al eliminar los datos");
		}
	}

	@Override
	public Categoria buscarCategoriaId(int idCategoria) {
		try {
			return categoriaRepositorio.findById(idCategoria).get();
		} catch (Exception e) {
			System.out.println("Error al editar los datos");
			return null;
		}
	}
}
