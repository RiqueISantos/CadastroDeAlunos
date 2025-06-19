package dev.henrique.CadastroDeAlunos.Cursos;

import dev.henrique.CadastroDeAlunos.Alunos.AlunosDTO;
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
    public ResponseEntity<String> criarCurso(@RequestBody CursosDTO cursosDto){
        CursosDTO curso = cursosService.criarCurso(cursosDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("O Curso: " + curso.getNome() + " foi criado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CursosDTO>> listarCursos(){
        List<CursosDTO> cursos = cursosService.listarCursos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarCursosPorId(@PathVariable Long id){
        CursosDTO curso = cursosService.listarCursosPorId(id);

        if(curso != null){
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarCurso(@PathVariable Long id, @RequestBody CursosDTO cursosDTO){
        CursosDTO curso = cursosService.atualizarCurso(id, cursosDTO);

        if(curso != null){
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCursoPorId(@PathVariable Long id){
        if(cursosService.listarCursosPorId(id) != null){
            cursosService.deletarCursoPorId(id);
            return ResponseEntity.ok("O curso de ID: " + id + " foi deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O curso de ID: " + id + " não existe.");
    }
}
