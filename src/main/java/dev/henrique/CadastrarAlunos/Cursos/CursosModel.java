package dev.henrique.CadastrarAlunos.Cursos;

import dev.henrique.CadastrarAlunos.Alunos.AlunosModel;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private int cargaHoraria;

    private double valor;

    private String modalidade;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    // Um curso pode ter varios alunos matriculados
    @OneToMany(mappedBy = "cursos")
    private List<AlunosModel> alunos;

}
