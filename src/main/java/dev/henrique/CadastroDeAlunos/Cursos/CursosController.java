package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    private CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    //Adicionar Curso
    @PostMapping("/criar")
    public CursosDTO criarCurso(@RequestBody CursosDTO cursosDto){
        return cursosService.criarCurso(cursosDto);
    }

    //Listar cursos
    @GetMapping("/listar")
    public List<CursosDTO> listarCursos(){
        return cursosService.listarCursos();
    }

    //Mostrar curso por ID
    @GetMapping("/listar/{id}")
    public CursosDTO listarCursosPorId(@PathVariable Long id){
        return cursosService.listarCursosPorId(id);
    }

    //Alterar dados dos cursos por ID
    @PutMapping("/atualizar/{id}")
    public CursosDTO alterarCurso(@PathVariable Long id, @RequestBody CursosDTO cursosDTO){
        return cursosService.atualizarCurso(id, cursosDTO);
    }

    //Deletar curso pelo ID
    @DeleteMapping("/deletar/{id}")
    public void deletarCursoPorId(@PathVariable Long id){
        cursosService.deletarCursoPorId(id);
    }
}
