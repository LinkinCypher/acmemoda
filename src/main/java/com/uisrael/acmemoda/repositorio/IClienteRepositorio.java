package com.uisrael.acmemoda.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer>{

	
}
