package com.uisrael.acmemoda.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String apellido;
	private String correo;
	private String direccion;
	private boolean estado;
	private Date fechaNacimiento;

	@Column(name = "cedula", length = 15)
	private String cedulaIdentidad;

	@Column(length = 10)
	private String telefono;

	@OneToMany(mappedBy = "fkCliente")
	private List<Pedido> listaPedidos = new ArrayList<>();
}
