package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }


    @PostMapping("/criar")
    public ResponseEntity<String> criarAluno(@RequestBody AlunosDTO aluno){
        AlunosDTO alunoDto = alunosService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O aluno: " + alunoDto.getNome() + " foi criado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunosDTO>> listarAlunos(){
        List<AlunosDTO> alunos = alunosService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAlunoPorId(@PathVariable Long id){
        AlunosDTO aluno = alunosService.listarAlunoPorId(id);
        if(aluno != null){
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O aluno de ID: " + id + " não existe.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody AlunosDTO alunoAtualizado){
        AlunosDTO aluno = alunosService.atualizarAluno(id, alunoAtualizado);
        if(aluno != null){
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O aluno de ID: " + id + " não existe.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAlunoPorId(@PathVariable Long id){
        if(alunosService.listarAlunoPorId(id) != null){
            alunosService.deletarAlunosPorId(id);
            return ResponseEntity.ok("O aluno de ID: " + id + " foi deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ID: " + id + " não existe.");
    }
}