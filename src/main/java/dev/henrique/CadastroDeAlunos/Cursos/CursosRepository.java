package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<CursosModel, Long> {
}
