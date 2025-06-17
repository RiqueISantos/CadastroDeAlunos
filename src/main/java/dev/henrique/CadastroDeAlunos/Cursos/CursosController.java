package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    //Adicionar Curso
    @PostMapping("/criar")
    public String criarCurso(){
        return "Curso criado com sucesso";
    }

    //Listar cursos
    @GetMapping("/listar")
    public String listarCursos(){
        return "Cursos listados com sucesso";
    }

    //Mostrar curso por ID
    @GetMapping("/listarID")
    public String listarTodosOsCursosPorId(){
        return "Listar curso por id";
    }

    //Alterar dados dos cursos por ID
    @PutMapping("/alterarID")
    public String alterarCursoPorId(){
        return "Alterar Curso por ID";
    }

    //Deletar curso pelo ID
    @DeleteMapping("/deletarID")
    public String deletarCursoPorId(){
        return "Curso deletado por ID";
    }
}
