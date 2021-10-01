package com.pragma.seguridad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pragma.seguridad.entity.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername (@Param ("nombre") String Username);
}
