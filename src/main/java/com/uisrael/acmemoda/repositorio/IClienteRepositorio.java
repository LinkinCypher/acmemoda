package com.uisrael.acmemoda.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.acmemoda.modelo.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Integer>{

	@Query("Select e From Cliente e where e.cedulaIdentidad=?1") //JPQL
	public Cliente buscarClienteId(String cedula);
	
	public List<Cliente> findByNombre(String nombre);
	
	public List<Cliente> findByApellido(String Apellido);
	
	public List<Cliente> findByFechaNacimiento(Date fechaNacimiento);
	
	public List<Cliente> findByCorreo(String correo);
	
	@Query("SELECT e FROM Cliente e WHERE YEAR(e.fechaNacimiento) BETWEEN :anioInicio AND :anioFin")
	public List<Cliente> buscarPorFechas(int anioInicio, int anioFin);
}
