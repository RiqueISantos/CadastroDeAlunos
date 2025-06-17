package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AlunosController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota de cadastro";
    }

    //Adicionar Aluno
    @PostMapping("/criar")
    public String criarAluno(){
        return "Aluno criado";
    }

    //Mostrar todos os alunos
    @GetMapping("/todos")
    public String mostrarTodosOsAlunos(){
        return "Mostrar aluno";
    }

    //Mostrar aluno por ID
    @GetMapping("/todosID")
    public String mostrarTodosOsAlunosPorId(){
        return "Mostrar aluno por id";
    }

    //Alterar dados dos alunos por ID
    @PutMapping("/alterarID")
    public String alterarAlunoPorId(){
        return "Alterar Aluno por ID";
    }

    //Deletar aluno pelo ID
    @DeleteMapping("/deletarID")
    public String deletarAlunoPorId(){
        return "Aluno deletado por ID";
    }
}