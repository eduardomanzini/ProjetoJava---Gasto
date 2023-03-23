package com.teste.service;

import com.teste.entidade.Gasto;
import com.teste.exeptions.ResourceNotFoundException;
import com.teste.gastoDto.GastoDto;
import com.teste.repository.GastoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class GastoService {

	public GastoRepository repo;

	public GastoService(GastoRepository repo) {
		this.repo = repo;
	}

	public List<Gasto> findAll() {
		return repo.findAll();
	}
	
	public Gasto findById(Long id) {
		Optional<Gasto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
	}

	@Transactional
	public Gasto insert(GastoDto obj) {
		var gasto = new Gasto();
		BeanUtils.copyProperties(obj , gasto);
		gasto.setData(LocalDateTime.now(ZoneId.of("UTC")));
		return repo.save(gasto);
	}

	public Gasto update(Long id, GastoDto obj) {
		Gasto gasto = findById(id);
		BeanUtils.copyProperties(obj , gasto, "id", "data");
		return repo.save(gasto);
	}


	@Transactional
	public void delete(Long id){
		Gasto gasto = findById(id);
		repo.delete(gasto);
	}

}

