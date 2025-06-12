package dev.henrique.CadastrarAlunos.Alunos;

import dev.henrique.CadastrarAlunos.Cursos.CursosModel;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_alunos")
public class AlunosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;
    List<CursosModel> cursos;
}
