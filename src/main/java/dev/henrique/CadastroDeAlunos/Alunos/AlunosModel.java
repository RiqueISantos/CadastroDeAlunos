package dev.henrique.CadastroDeAlunos.Alunos;

import dev.henrique.CadastroDeAlunos.Cursos.CursosModel;
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
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "nome",length = 100)
    private String nome;

    @Column(unique = true, name = "email", nullable = false)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "endereco")
    private String endereco;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    // Um aluno esta matriculado em um unico curso
    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private CursosModel cursos;
}
