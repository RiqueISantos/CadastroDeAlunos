package dev.henrique.CadastroDeAlunos.Cursos;

import dev.henrique.CadastroDeAlunos.Alunos.AlunosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosDTO {

    private Long id;
    private String nome;
    private int cargaHoraria;
    private double valor;
    private String modalidade;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private List<AlunosModel> alunos;

}
