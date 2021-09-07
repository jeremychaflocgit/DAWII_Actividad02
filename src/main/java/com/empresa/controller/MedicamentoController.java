package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listar(){
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> registra(@RequestBody Medicamento obj){
		Medicamento objSalida = service.registraMedicamento(obj);
		return ResponseEntity.ok(objSalida);
	}
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> consultaxId(@PathVariable("paramId") int idMedicamento){
		Optional<Medicamento> optMedicamento = service.consultaxId(idMedicamento);
		if(optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		}
		else {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> consultaxNombre(@PathVariable("paramNombre") String nombre){
		List<Medicamento> lista = service.consultaxNombre(nombre);
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/stock/{paramStock}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> consultaxStock(@PathVariable("paramStock") int stock){
		List<Medicamento> lista = service.consultaxStock(stock);
		if(CollectionUtils.isEmpty(lista)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return ResponseEntity.ok(lista);
		}
	}
	
}
