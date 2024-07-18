package com.uisrael.acmemoda.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uisrael.acmemoda.modelo.Pedido;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByFkClienteIdCliente(int idCliente);
}
