package dev.henrique.CadastrarAlunos.Alunos;

import dev.henrique.CadastrarAlunos.Cursos.CursosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private int idade;

    private String endereco;

    @Column(unique = true)
    private String cpf;

    private String telefone;

    // Um aluno esta matriculado em um unico curso
    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private CursosModel cursos;
}
