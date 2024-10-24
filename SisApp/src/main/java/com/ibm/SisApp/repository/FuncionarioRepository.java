package com.ibm.SisApp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.SisApp.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Busca por nome (contém)
    Page<Funcionario> findByNomeContaining(String nome, Pageable pageable);

    // Busca por função (contém)
    Page<Funcionario> findByFuncaoContaining(String funcao, Pageable pageable);

    // Busca por nome e função ao mesmo tempo
    @Query("SELECT f FROM Funcionario f WHERE (:nome IS NULL OR f.nome LIKE %:nome%) AND (:funcao IS NULL OR f.funcao LIKE %:funcao%)")
    Page<Funcionario> findByNomeAndFuncao(@Param("nome") String nome, @Param("funcao") String funcao, Pageable pageable);
}
