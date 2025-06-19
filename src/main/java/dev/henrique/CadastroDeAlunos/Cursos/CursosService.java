package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    private CursosRepository cursosRepository;
    private CursosMapper cursosMapper;

    public CursosService(CursosRepository cursosRepository, CursosMapper cursosMapper) {
        this.cursosRepository = cursosRepository;
        this.cursosMapper = cursosMapper;
    }

    public List<CursosModel> listarCursos(){
        return cursosRepository.findAll();
    }

    public CursosModel listarCursosPorId(Long id){
        Optional<CursosModel> cursosPorId = cursosRepository.findById(id);
        return cursosPorId.orElse(null);
    }

    public CursosDTO criarCurso(CursosDTO cursosDTO){
        CursosModel cursos = cursosMapper.map(cursosDTO);
        cursos = cursosRepository.save(cursos);
        return cursosMapper.map(cursos);
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