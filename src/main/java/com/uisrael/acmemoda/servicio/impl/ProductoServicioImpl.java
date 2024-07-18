package com.uisrael.acmemoda.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.acmemoda.modelo.Producto;
import com.uisrael.acmemoda.repositorio.IProductoRepositorio;
import com.uisrael.acmemoda.servicio.IProductoServicio;

@Service
@Component
public class ProductoServicioImpl implements IProductoServicio {

    @Autowired
    IProductoRepositorio productoRepositorio;
    
    @Override
    public void insertarProducto(Producto nuevoProducto) {
        try {
            productoRepositorio.save(nuevoProducto);
        } catch (Exception e) {
            System.out.println("Error al ingresar datos");
        }
    }

    @Override
    public List<Producto> listarProducto() {
        try {
            return productoRepositorio.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar los datos");
            return null;
        }
    }

    @Override
    public void actualizarProducto(Producto editarProducto) {
        try {
            productoRepositorio.save(editarProducto);
        } catch (Exception e) {
            System.out.println("Error al editar los datos");
        }
    }

    @Override
    public void eliminarProducto(int idProducto) {
        try {
            productoRepositorio.deleteById(idProducto);
        } catch (Exception e) {
            System.out.println("Error al eliminar los datos");
        }
    }

    @Override
    public Producto buscarProductoId(int idProducto) {
        try {
            return productoRepositorio.findById(idProducto).get();
        } catch (Exception e) {
            System.out.println("Error al buscar el producto por ID");
            return null;
        }
    }

    @Override
    public List<Producto> buscarProductosPorCategoriaId(int idCategoria) {
        try {
            return productoRepositorio.findByFkCategoriaIdCategoria(idCategoria);
        } catch (Exception e) {
            System.out.println("Error al buscar productos por categoría");
            return null;
        }
    }
}
