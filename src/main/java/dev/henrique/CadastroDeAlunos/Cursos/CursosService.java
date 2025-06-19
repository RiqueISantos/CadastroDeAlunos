package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    private CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }


    public List<CursosModel> listarCursos(){
        return cursosRepository.findAll();
    }

    public CursosModel listarCursosPorId(Long id){
        Optional<CursosModel> cursosPorId = cursosRepository.findById(id);
        return cursosPorId.orElse(null);
    }

    public CursosModel criarCurso(CursosModel cursosModel){
        return cursosRepository.save(cursosModel);
    }

    public CursosModel atualizarCurso(Long id, CursosModel cursosModel){
        if(cursosRepository.existsById(id)){
            cursosModel.setId(id);
            return cursosRepository.save(cursosModel);
        }
        return null;
    }

    public void deletarCursoPorId(Long id){
        cursosRepository.deleteById(id);
    }

}