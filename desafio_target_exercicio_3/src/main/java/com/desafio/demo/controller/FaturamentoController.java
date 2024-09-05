package com.desafio.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.demo.controller.dto.FaturamentoResponseDto;
import com.desafio.demo.model.Faturamento;
import com.desafio.demo.services.FaturamentoService;

@RestController
@RequestMapping("/faturamento")
public class FaturamentoController {

	@Autowired
	private FaturamentoService service;
	
	@PostMapping
	public ResponseEntity<FaturamentoResponseDto> calcularFaturamento(@RequestBody List<Faturamento> dados){
		double menor = service.calcularMenorFaturamento(dados);
		double maior = service.calcularMaiorFaturamento(dados);
		double media = service.calcularMediaDeFaturamento(dados);
		long diasAcima = service.calcuarDiasAcimaDaMedia(dados);
		var faturamentoResponse = new FaturamentoResponseDto("R$ " + String.format("%.2f", menor)
				, "R$ " + String.format("%.2f", maior)
				, "R$ " + String.format("%.2f", media)
				, diasAcima);
		return ResponseEntity.ok(faturamentoResponse);
	}
}
