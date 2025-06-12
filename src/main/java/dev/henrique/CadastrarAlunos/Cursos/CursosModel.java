package dev.henrique.CadastrarAlunos.Cursos;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cursos")
public class CursosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    int cargaHoraria;

}
