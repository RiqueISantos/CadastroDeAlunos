package dev.henrique.CadastroDeAlunos.Cursos;

import dev.henrique.CadastroDeAlunos.Alunos.AlunosDTO;
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
@RequestMapping("/cursos")
public class CursosController {

    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo curso", description = "Essa rota cria um novo curso e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursosDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do curso",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> criarCurso(@RequestBody CursosDTO cursosDto){
        CursosDTO curso = cursosService.criarCurso(cursosDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Curso: " + curso.getNome() + " foi criado com sucesso!");
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Lista todos os cursos",
            description = "Retorna uma lista com todos os cursos cadastrados no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cursos retornada com sucesso",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CursosDTO.class)))),
            @ApiResponse(responseCode = "204", description = "Nenhum curso encontrado")
    })
    public ResponseEntity<List<CursosDTO>> listarCursos(){
        List<CursosDTO> cursos = cursosService.listarCursos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o curso pelo ID", description = "Essa rota lista um curso pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<?> listarCursosPorId(@PathVariable Long id){
        CursosDTO curso = cursosService.listarCursosPorId(id);

        if(curso != null){
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }

    @PutMapping("/atualizar/{id}")
    @Operation(
            summary = "Atualiza um curso existente",
            description = "Atualiza os dados de um curso existente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursosDTO.class))),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<?> alterarCurso(@PathVariable Long id, @RequestBody CursosDTO cursosDTO){
        CursosDTO curso = cursosService.atualizarCurso(id, cursosDTO);

        if(curso != null){
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deleta um curso por ID",
            description = "Remove um curso específico do banco de dados com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso deletado com sucesso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> deletarCursoPorId(@PathVariable Long id){
        if(cursosService.listarCursosPorId(id) != null){
            cursosService.deletarCursoPorId(id);
            return ResponseEntity.ok("O curso de ID: " + id + " foi deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }
}
