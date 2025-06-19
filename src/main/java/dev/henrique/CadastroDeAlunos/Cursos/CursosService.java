package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursosService {

    private CursosRepository cursosRepository;
    private CursosMapper cursosMapper;

    public CursosService(CursosRepository cursosRepository, CursosMapper cursosMapper) {
        this.cursosRepository = cursosRepository;
        this.cursosMapper = cursosMapper;
    }

    public List<CursosDTO> listarCursos(){
        List<CursosModel> cursos = cursosRepository.findAll();
        return cursos.stream()
                .map(cursosMapper::map)
                .collect(Collectors.toList());
    }

    public CursosDTO listarCursosPorId(Long id){
        Optional<CursosModel> cursosPorId = cursosRepository.findById(id);
        return cursosPorId.map(cursosMapper::map).orElse(null);
    }

    public CursosDTO criarCurso(CursosDTO cursosDTO){
        CursosModel cursos = cursosMapper.map(cursosDTO);
        cursos = cursosRepository.save(cursos);
        return cursosMapper.map(cursos);
    }

    public CursosDTO atualizarCurso(Long id, CursosDTO cursosDto){
        Optional<CursosModel> cursoExiste = cursosRepository.findById(id);
        if(cursoExiste.isPresent()){
            CursosModel cursoAtualizado = cursosMapper.map(cursosDto);
            cursoAtualizado.setId(id);
            CursosModel cursoSalvo = cursosRepository.save(cursoAtualizado);
            return cursosMapper.map(cursoSalvo);
        }
        return null;
    }

    public void deletarCursoPorId(Long id){
        cursosRepository.deleteById(id);
    }

}