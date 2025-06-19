package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota de cadastro";
    }

    //Adicionar Aluno
    @PostMapping("/criar")
    public AlunosModel criarAluno(@RequestBody AlunosModel aluno){
        return alunosService.criarAluno(aluno);
    }

    //Mostrar todos os alunos
    @GetMapping("/listar")
    public List<AlunosModel> listarAlunos(){
        return  alunosService.listarAlunos();
    }

    //Mostrar aluno por ID
    @GetMapping("/listar/{id}")
    public AlunosModel listarAlunoPorId(@PathVariable Long id){
        return alunosService.listarAlunoPorId(id);
    }

    //Alterar dados dos alunos por ID
    @PutMapping("/alterarID")
    public String alterarAlunoPorId(){
        return "Alterar Aluno por ID";
    }

    //Deletar aluno pelo ID
    @DeleteMapping("/deletar/{id}")
    public void deletarAlunoPorId(@PathVariable Long id){
        alunosService.deletarAlunosPorId(id);
    }
}