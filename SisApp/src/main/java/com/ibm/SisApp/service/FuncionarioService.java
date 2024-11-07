package com.ibm.SisApp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ibm.SisApp.model.Funcionario;

public interface FuncionarioService {

	// Método para salvar ou atualizar um funcionário
	Funcionario salvarOuAtualizar(Funcionario funcionario);

	// Método para listar funcionários com paginação
	Page<Funcionario> listarTodos(Pageable pageable);

	// Método para buscar funcionários por nome e/ou função com paginação
	Page<Funcionario> buscarPorNomeEFuncao(String nome, String funcao, Pageable pageable);

	// Buscar um funcionário por ID
	Funcionario buscarPorId(Long id);

	// Salvar um novo funcionário
	Funcionario salvar(Funcionario funcionario);

	// Excluir um funcionário por ID
	boolean excluir(Long id);
}