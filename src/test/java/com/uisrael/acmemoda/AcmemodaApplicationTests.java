package com.uisrael.acmemoda;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.acmemoda.modelo.Cliente;
import com.uisrael.acmemoda.modelo.Pedido;
import com.uisrael.acmemoda.servicio.IClienteServicio;
import com.uisrael.acmemoda.servicio.IPedidoServicio;

@SpringBootTest
class AcmemodaApplicationTests {

	@Autowired
	IClienteServicio clienteServicio;
	@Autowired
	IPedidoServicio pedidoServicio;

	@Test
	void contextLoads() {

		Cliente nuevoCliente = new Cliente();
		nuevoCliente.setNombre("Cristhian");
		nuevoCliente.setApellido("Mora");
		nuevoCliente.setTelefono("1234567890");
		nuevoCliente.setCi("0987654321");
		nuevoCliente.setCorreo("cristhian@mail.com");
		nuevoCliente.setDireccion("Quito");
		clienteServicio.insertarCliente(nuevoCliente);

		List<Cliente> resultadoSelect = clienteServicio.listarCliente();

		Pedido nuevoPedido = new Pedido();
		nuevoPedido.setFecha(null);
		nuevoPedido.setFkCliente(nuevoCliente);
		pedidoServicio.insertarPedido(nuevoPedido);
		
	}

}
