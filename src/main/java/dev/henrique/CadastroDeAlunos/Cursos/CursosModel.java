package dev.henrique.CadastroDeAlunos.Cursos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.henrique.CadastroDeAlunos.Alunos.AlunosModel;
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
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "nome", length = 100)
    private String nome;

    @Column(name = "carga_horaria")
    private int cargaHoraria;

    @Column(name = "valor")
    private double valor;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    // Um curso pode ter varios alunos matriculados
    @OneToMany(mappedBy = "cursos")
    @JsonIgnore
    private List<AlunosModel> alunos;

}

