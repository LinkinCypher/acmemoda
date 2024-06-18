package com.uisrael.acmemoda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
