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
    public CursosModel criarCurso(@RequestBody CursosModel cursosModel){
        return cursosService.criarCurso(cursosModel);
    }

    //Listar cursos
    @GetMapping("/listar")
    public List<CursosModel> listarCursos(){
        return cursosService.listarCursos();
    }

    //Mostrar curso por ID
    @GetMapping("/listar/{id}")
    public CursosModel listarCursosPorId(@PathVariable Long id){
        return cursosService.listarCursosPorId(id);
    }

    //Alterar dados dos cursos por ID
    @PutMapping("/atualizar/{id}")
    public CursosModel alterarCurso(@PathVariable Long id, @RequestBody CursosModel cursosModel){
        return cursosService.atualizarCurso(id, cursosModel);
    }

    //Deletar curso pelo ID
    @DeleteMapping("/deletar/{id}")
    public void deletarCursoPorId(@PathVariable Long id){
        cursosService.deletarCursoPorId(id);
    }
}
