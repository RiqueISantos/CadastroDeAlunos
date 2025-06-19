package dev.henrique.CadastroDeAlunos.Alunos;

import dev.henrique.CadastroDeAlunos.Cursos.CursosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String endereco;
    private String cpf;
    private String telefone;
    private CursosModel cursos;

}
