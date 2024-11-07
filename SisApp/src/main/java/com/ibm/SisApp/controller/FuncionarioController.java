package com.ibm.SisApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.ibm.SisApp.service.FuncionarioService;
import com.ibm.SisApp.model.Funcionario;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	// Método para listar funcionários com filtro por nome e/ou função
	@GetMapping("/funcionario/listagem")
	public String listarFuncionarios(Model model, @RequestParam(defaultValue = "0") int page,
			@RequestParam(required = false) String nome, @RequestParam(required = false) String funcao) {
		Pageable pageable = PageRequest.of(page, 5); // Define o tamanho da página (5 funcionários por página)
		Page<Funcionario> funcionarios = funcionarioService.buscarPorNomeEFuncao(nome, funcao, pageable);
		model.addAttribute("lista", funcionarios.getContent());
		model.addAttribute("pagina", funcionarios);
		model.addAttribute("nome", nome); // Manter o nome no campo de busca
		model.addAttribute("funcao", funcao); // Manter a função no campo de busca
		return "listagem";
	}

	// Exibir o formulário para cadastro de funcionário
	@GetMapping("/funcionario")
	public String exibirFormFuncionario(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "formFuncionario";
	}

	// Salvar funcionário
	@PostMapping("/funcionario")
	public String salvarFuncionario(Funcionario funcionario) {
		funcionarioService.salvar(funcionario);
		return "redirect:/funcionario/listagem";
	}

	// Editar um funcionário existente
	@GetMapping("/funcionario/formFuncionario")
	public String editarFuncionario(@RequestParam Long id, Model model) {
		Funcionario funcionario = funcionarioService.buscarPorId(id);
		model.addAttribute("funcionario", funcionario);
		return "formFuncionario";
	}

	// Excluir um funcionário
	// Excluir um funcionário
	@DeleteMapping("/funcionario")
	public String excluirFuncionario(@RequestParam Long id, Model model) {
		if (funcionarioService.excluir(id)) {
			model.addAttribute("message", "Funcionário excluído com sucesso.");
		} else {
			model.addAttribute("error", "Erro: Funcionário não encontrado.");
		}
		return "redirect:/funcionario/listagem";
	}

}