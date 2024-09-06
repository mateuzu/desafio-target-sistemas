package service.impl;

import java.util.List;

import model.Faturamento;
import service.FaturamentoService;

public class FaturamentoServiceImpl implements FaturamentoService{

	private double menorFaturamento;
	private double maiorFaturamento;
	private double mediaFaturamento;
	private long diasAcima;
	
	public FaturamentoServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public double getMenorFaturamento() {
		return menorFaturamento;
	}

	public double getMaiorFaturamento() {
		return maiorFaturamento;
	}

	public double getMediaFaturamento() {
		return mediaFaturamento;
	}

	public long getDiasAcima() {
		return diasAcima;
	}


	@Override
	public void menorFaturamento(List<Faturamento> dados) {
		double menor = dados.stream()
				.filter(faturamento -> faturamento.getValor() > 0)
				.mapToDouble(Faturamento::getValor)
				.min().orElse(0);
		
		this.menorFaturamento = menor;
	}

	@Override
	public void maiorFaturamento(List<Faturamento> dados) {
		double maior = dados.stream()
				.filter(faturamento -> faturamento.getValor() > 0)
				.mapToDouble(Faturamento::getValor)
				.max().orElse(0);
		
		this.maiorFaturamento = maior;
	}

	@Override
	public void mediaFaturamento(List<Faturamento> dados) {
		var valores = dados.stream()
				.filter(faturamento -> faturamento.getValor() > 0)
				.map(Faturamento::getValor)
				.toList();
		
		double soma = valores.stream()
				.mapToDouble(value -> value)
				.sum();
		
		double media = soma / valores.size();
		
		this.mediaFaturamento = media;
	}

	@Override
	public void diasAcima(List<Faturamento> dados) {
		double media = getMediaFaturamento();
		
		long dias = dados.stream()
				.filter(faturamentos -> faturamentos.getDia() > 0 
						&& faturamentos.getValor() > media)
				.count();
		this.diasAcima = dias;
	}

}
