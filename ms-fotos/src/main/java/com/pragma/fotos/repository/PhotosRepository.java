package com.pragma.fotos.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.pragma.fotos.model.Photos;

@Component
public interface PhotosRepository extends MongoRepository<Photos, Long> {
	@Query("{'clienteId':?0}")
	public Optional<Photos> findByClienteId(Long clientId);
}
