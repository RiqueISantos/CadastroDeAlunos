package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
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
    @GetMapping("/listar")
    public String listarTodosOsAlunos(){
        return "Listar aluno";
    }

    //Mostrar aluno por ID
    @GetMapping("/listarID")
    public String listarTodosOsAlunosPorId(){
        return "Listar aluno por id";
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