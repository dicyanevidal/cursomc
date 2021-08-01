package com.dicyanevidal.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dicyanevidal.cursomc.domain.Categoria;
import com.dicyanevidal.cursomc.repository.CategoriaRepository;
import com.dicyanevidal.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired  //Essa dependecia será instanciada pelo próprio spring pelo mecanismo injeção de dependencia ou inversão de controle
	private CategoriaRepository repositorio;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}	
}
