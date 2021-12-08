package com.danilods.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilods.cursomc.domain.Categoria;
import com.danilods.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
		} 

}