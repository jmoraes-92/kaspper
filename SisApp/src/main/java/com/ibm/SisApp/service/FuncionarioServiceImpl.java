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

	@Override
	@Transactional(readOnly = true)
	public Page<Funcionario> listarTodos(Pageable pageable) {
		return funcionarioRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
	}

	@Override
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		if (!funcionarioRepository.existsById(id)) {
			throw new RuntimeException("Funcionário não encontrado");
		}
		funcionarioRepository.deleteById(id);
	}
}
