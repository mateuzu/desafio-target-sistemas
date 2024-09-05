package model;

import java.text.DecimalFormat;

import service.CalcularFaturamento;

public class Estado implements CalcularFaturamento{

	private String nome;
	private double valorFaturamento;
	
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	
	public Estado(String nome, double valorFaturamento) {
		this.nome = nome;
		this.valorFaturamento = valorFaturamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorFaturamento() {
		return valorFaturamento;
	}

	public void setValorFaturamento(double valorFaturamento) {
		this.valorFaturamento = valorFaturamento;
	}

	@Override
	public double calcularFaturamento(double valorTotal) {
		setValorFaturamento((getValorFaturamento() / valorTotal) * 100);
		return getValorFaturamento();
	}

	@Override
	public String imprimirResultado() {
		DecimalFormat formato = new DecimalFormat("#.00");
		return nome + ": " + formato.format(getValorFaturamento()) + "%";
	}
	
}
