package com.ibm.SisApp.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.SisApp.model.Funcionario;

public interface FuncionarioService {

	// Método para listar funcionários com paginação
	Page<Funcionario> listarTodos(Pageable pageable);

	// Método para buscar um funcionário por ID
	Funcionario buscarPorId(Long id);

	// Método para salvar um novo funcionário ou atualizar
	Funcionario salvar(Funcionario funcionario);

	// Método para excluir um funcionário pelo ID
	void excluir(Long id);
}
