package com.danilods.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.danilods.cursomc.domain.Categoria;
import com.danilods.cursomc.repositories.CategoriaRepository;
import com.danilods.cursomc.services.exeptions.DataIntegrityException;
import com.danilods.cursomc.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	} 
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
		
	}
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}
	public void delete (Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
		
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	

}
