package com.pragma.clientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pragma.clientes.model.Clientes;

@Repository
public interface ClienteRepository  extends JpaRepository<Clientes,Long> {
	public List<Clientes> findByEstadoIs(Integer estado);
	
	public Optional<Clientes> findByNumeroIdentificadorAndEstadoIs(String numeroIdentificador,Integer estado);
	
	public List<Clientes> findByEdadGreaterThanEqualAndEstadoIs(int edad,Integer estado);
}
