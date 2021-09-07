package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService{
	public Medicamento registraMedicamento(Medicamento obj);
	public List<Medicamento> listaMedicamento();
	public abstract Optional<Medicamento> consultaxId(int idMedicamento);
	public abstract List<Medicamento> consultaxNombre(String nombre);
	public abstract List<Medicamento> consultaxStock(int stock);
}
