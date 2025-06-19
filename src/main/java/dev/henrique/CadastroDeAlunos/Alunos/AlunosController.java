package dev.henrique.CadastroDeAlunos.Alunos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }


    @PostMapping("/criar")
    @Operation(
            summary = "Cria um novo aluno",
            description = "Cria um novo aluno com os dados fornecidos e salva no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do aluno",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> criarAluno(@RequestBody AlunosDTO aluno){
        AlunosDTO alunoDto = alunosService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O aluno: " + alunoDto.getNome() + " foi criado com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Lista todos os alunos",
            description = "Retorna uma lista com todos os alunos cadastrados no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AlunosDTO.class)))),
            @ApiResponse(responseCode = "204", description = "Nenhum aluno encontrado")
    })
    public ResponseEntity<List<AlunosDTO>> listarAlunos(){
        List<AlunosDTO> alunos = alunosService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/listar/{id}")
    @Operation(
            summary = "Busca um aluno por ID",
            description = "Retorna os dados de um aluno específico com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<?> listarAlunoPorId(@PathVariable Long id){
        AlunosDTO aluno = alunosService.listarAlunoPorId(id);
        if(aluno != null){
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O aluno de ID: " + id + " não existe.");
    }

    @PutMapping("/atualizar/{id}")
    @Operation(
            summary = "Atualiza um aluno existente",
            description = "Atualiza os dados de um aluno com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualização",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody AlunosDTO alunoAtualizado){
        AlunosDTO aluno = alunosService.atualizarAluno(id, alunoAtualizado);
        if(aluno != null){
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O aluno de ID: " + id + " não existe.");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deleta um aluno por ID",
            description = "Remove um aluno específico do banco de dados com base no ID informado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> deletarAlunoPorId(@PathVariable Long id){
        if(alunosService.listarAlunoPorId(id) != null){
            alunosService.deletarAlunosPorId(id);
            return ResponseEntity.ok("O aluno de ID: " + id + " foi deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ID: " + id + " não existe.");
    }
}