package dev.henrique.CadastrarAlunos.Alunos;

import dev.henrique.CadastrarAlunos.Cursos.CursosModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_alunos")
public class AlunosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // Um aluno esta matriculado em um unico curso
    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private CursosModel cursos;
}
