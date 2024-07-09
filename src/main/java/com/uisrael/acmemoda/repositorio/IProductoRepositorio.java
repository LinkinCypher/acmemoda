package com.uisrael.acmemoda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.acmemoda.modelo.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer>{

}
