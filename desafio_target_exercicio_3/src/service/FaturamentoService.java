package service;

import java.util.List;

import model.Faturamento;

public interface FaturamentoService {

	void menorFaturamento(List<Faturamento> dados);
	void maiorFaturamento(List<Faturamento> dados);
	void mediaFaturamento(List<Faturamento> dados);
	void diasAcima (List<Faturamento> dados);
}
