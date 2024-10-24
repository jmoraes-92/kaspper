package com.ibm.SisApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ibm.SisApp.model.Funcionario;
import com.ibm.SisApp.repository.FuncionarioRepository;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	// Método para salvar ou atualizar um funcionário
	@Override
	public Funcionario salvarOuAtualizar(Funcionario funcionario) {
		if (funcionario.getId() != null) {
			Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(funcionario.getId());
			if (funcionarioExistente.isPresent()) {
				Funcionario atualizado = funcionarioExistente.get();
				atualizado.setNome(funcionario.getNome());
				atualizado.setFuncao(funcionario.getFuncao());
				atualizado.setDtadm(funcionario.getDtadm());
				atualizado.setSalario(funcionario.getSalario());
				return funcionarioRepository.save(atualizado);
			}
		}
		return funcionarioRepository.save(funcionario);
	}

	// Método para listar funcionários com paginação
	@Override
	@Transactional(readOnly = true)
	public Page<Funcionario> listarTodos(Pageable pageable) {
		return funcionarioRepository.findAll(pageable);
	}

	// Método para buscar por nome e função
	@Override
	@Transactional(readOnly = true)
	public Page<Funcionario> buscarPorNomeEFuncao(String nome, String funcao, Pageable pageable) {
		return funcionarioRepository.findByNomeAndFuncao(nome, funcao, pageable);
	}

	// Buscar um funcionário por ID
	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
	}

	// Salvar um novo funcionário
	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	// Excluir um funcionário por ID
	@Override
	@Transactional
	public boolean excluir(Long id) {
	    if (!funcionarioRepository.existsById(id)) {
	        return false; // Retorna falso se o funcionário não for encontrado
	    }
	    funcionarioRepository.deleteById(id);
	    return true; // Retorna verdadeiro se a exclusão for bem-sucedida
	}

}
