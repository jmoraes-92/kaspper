package com.ibm.SisApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.SisApp.model.DadosCadastroProduto;

import com.ibm.SisApp.model.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private List<Produtos> produtos = new ArrayList<>();

	@GetMapping
	public String mostrarFormularioProduto() {
		return "produto/formProduto";
	}

	@PostMapping
	public String cadastrarProduto(DadosCadastroProduto dados) {
		var produto = new Produtos(dados);
		produtos.add(produto);
		System.out.println(produto);
		return "funcionario/formProduto";

	}
}
