package com.teste.resource;

import com.teste.entidade.Gasto;
import com.teste.gastoDto.GastoDto;
import com.teste.service.GastoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/gastos")
@Api(value = "API REST Gastos")
@CrossOrigin(origins="*")
public class GastoResource {

	private final GastoService service;

	public GastoResource(GastoService service) {
		this.service = service;
	}


	@GetMapping
	@ApiOperation(value = "Retorna uma lista de Gastos")
	public ResponseEntity<List<Gasto>> findByAll() {
		List<Gasto> list = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um gasto unico")
	public ResponseEntity<Gasto> findById(@PathVariable(value="id") Long id) {
		Gasto gasto = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(gasto);
	}


	@PostMapping
	@ApiOperation(value = "Salvar um Gasto")
	public ResponseEntity<Gasto> insert(@RequestBody @Valid GastoDto obj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(obj));
	}


	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deletar um produto")
	@RolesAllowed("ADMIN")
	public ResponseEntity<Void> delete(@PathVariable(value="id") Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<Void> update(@PathVariable(value="id") Long id, @RequestBody @Valid GastoDto obj) {
		service.update(id, obj);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
