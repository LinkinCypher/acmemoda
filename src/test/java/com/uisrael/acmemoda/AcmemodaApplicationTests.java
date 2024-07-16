package com.uisrael.acmemoda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.acmemoda.modelo.Categoria;
import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.modelo.Detalle;
import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.modelo.Producto;
import com.uisrael.acmemoda.servicio.ICategoriaServicio;
import com.uisrael.acmemoda.servicio.IClienteServicio;
import com.uisrael.acmemoda.servicio.IDetalleServicio;
import com.uisrael.acmemoda.servicio.IPedidoServicio;
import com.uisrael.acmemoda.servicio.IProductoServicio;

@SpringBootTest
class AcmemodaApplicationTests {

	@Autowired
	IClienteServicio clienteServicio;
	@Autowired
	IPedidoServicio pedidoServicio;
	@Autowired
	ICategoriaServicio categoriaServicio;
	@Autowired
	IProductoServicio productoServicio;
	@Autowired
	IDetalleServicio detalleServicio;

	@Test
	void contextLoads() {

		
		
		// INSERTAR CLIENTE
		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setNombre("Cristhian");
		nuevoCliente.setApellido("Mora");
		nuevoCliente.setTelefono("1234567890");
		nuevoCliente.setCedulaIdentidad("0987654321");
		nuevoCliente.setCorreo("cristhian@mail.com");
		nuevoCliente.setDireccion("Quito");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNacimiento = dateFormat.parse("2004-04-24");
            nuevoCliente.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
        }
        
		clienteServicio.insertarCliente(nuevoCliente);

		

		// INSERTAR PEDIDO (CLIENTE -> PEDIDO)
		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setFecha(new Date());
		nuevoPedido.setFkCliente(nuevoCliente);
		pedidoServicio.insertarPedido(nuevoPedido);
		
		
		
		// INSERTAR CATEGORIA
		Categoria nuevoCategoria = new Categoria();
		nuevoCategoria.setNombre("Damas");
		nuevoCategoria.setDescripcion("Ropa para damas");
		categoriaServicio.insertarCategoria(nuevoCategoria);
		
		
		
		// INSERTAR PRODUCTO (CATEGORIA -> PRODUCTO)
		Producto nuevoProducto = new Producto();
		nuevoProducto.setNombre("Camisa");
		nuevoProducto.setDescripcion("Talla G");
		nuevoProducto.setStock(2);
		//nuevoProducto.setCosto(10.20);
		nuevoProducto.setFkCategoria(nuevoCategoria);
		productoServicio.insertarProducto(nuevoProducto);
		
		
		
		// INSERTAR DETALLE (PEDIDO -> DETALLE && PRODUCTO -> DETALLE)
		Detalle nuevoDetalle = new Detalle();
		nuevoDetalle.setCantidad(10);
		nuevoDetalle.setFkPedido(nuevoPedido);
		nuevoDetalle.setFkProducto(nuevoProducto);
		detalleServicio.insertarDetalle(nuevoDetalle);
		
		
		
		// LISTAR
		List<Cliente> resultadoSelect = clienteServicio.listarCliente();
		
		List<Cliente>lista=clienteServicio.listarCliente();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getIdCliente() + " " + cliente.getApellido() + " " + cliente.getNombre());
		}
		
		System.out.println("Buscar por Nombre");
		List<Cliente>lista1=clienteServicio.findByNombre("Cristhian");
		for (Cliente cliente : lista1) {
			System.out.println(cliente.getIdCliente() + " " + cliente.getApellido() + " " + cliente.getNombre());
		}
		
		System.out.println("Buscar por Apellido");
		List<Cliente>lista2=clienteServicio.findByApellido("Mora");
		for (Cliente cliente : lista2) {
			System.out.println(cliente.getIdCliente() + " " + cliente.getApellido() + " " + cliente.getNombre());
		}
		
		System.out.println("Buscar por Fechas");
		List<Cliente>lista3=clienteServicio.buscarPorFecha(1994,2024);
		for (Cliente cliente : lista3) {
			System.out.println(cliente.getIdCliente() + " " + cliente.getApellido() + " " + cliente.getNombre());
		}
		
		
	}

}
