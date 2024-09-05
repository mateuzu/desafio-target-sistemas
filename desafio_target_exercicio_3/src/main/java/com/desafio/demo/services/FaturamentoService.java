package com.desafio.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.demo.model.Faturamento;

@Service
public class FaturamentoService {

	public double calcularMenorFaturamento(List<Faturamento> dados) {
		double menor = dados.stream().filter(t -> t.getValor() > 0).mapToDouble(value -> value.getValor()).min().orElse(0);
		return menor;
	}
	
	public double calcularMaiorFaturamento(List<Faturamento> dados) {
		double maior = dados.stream().filter(t -> t.getValor() > 0).mapToDouble(value -> value.getValor()).max().orElse(0);
		return maior;
	}
	
	public long calcuarDiasAcimaDaMedia(List<Faturamento> dados) {
		double media = calcularMediaDeFaturamento(dados);
		var diasAcima = dados.stream().filter(t -> t.getDia() > 0).filter(f -> f.getValor() > media).count();
		return diasAcima;
	}
	
	public double calcularMediaDeFaturamento(List<Faturamento> dados) {
		var valores = dados.stream().filter(t -> t.getValor() > 0).map(t -> t.getValor()).toList();
		double soma = valores.stream().mapToDouble(value -> value.doubleValue()).sum();
		double media = soma / valores.size();
		return media;
	}
}
