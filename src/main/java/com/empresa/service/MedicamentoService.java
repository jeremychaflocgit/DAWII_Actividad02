package com.empresa.service;

import java.util.List;

import com.empresa.entity.Medicamento;

public interface MedicamentoService{
	public Medicamento registraMedicamento(Medicamento obj);
	public List<Medicamento> listaMedicamento();
}
