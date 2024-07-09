package com.uisrael.acmemoda.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_detalle")
public class Detalle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private int cantidad;
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_Pedido")
	private Pedido fkPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_Producto")
	private Producto fkProducto;
}
