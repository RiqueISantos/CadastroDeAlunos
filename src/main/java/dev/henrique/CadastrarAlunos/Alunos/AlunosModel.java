package dev.henrique.CadastrarAlunos.Alunos;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class AlunosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;
}
