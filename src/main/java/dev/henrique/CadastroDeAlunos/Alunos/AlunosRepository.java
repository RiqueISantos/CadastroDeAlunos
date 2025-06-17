package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {
}
