package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoImp implements MedicamentoService{

	@Autowired
	private MedicamentoRepository repository;
	
	@Override
	public Medicamento registraMedicamento(Medicamento obj) {
		return repository.save(obj);
	}

	@Override
	public List<Medicamento> listaMedicamento() {
		return repository.findAll();
	}

	@Override
	public Optional<Medicamento> consultaxId(int idMedicamento) {
		return repository.findById(idMedicamento);
	}

	@Override
	public List<Medicamento> consultaxNombre(String nombre) {
		return repository.ConsultaNombreLike(nombre);
	}

	@Override
	public List<Medicamento> consultaxStock(int stock) {
		return repository.findByStock(stock);
	}
	
}
