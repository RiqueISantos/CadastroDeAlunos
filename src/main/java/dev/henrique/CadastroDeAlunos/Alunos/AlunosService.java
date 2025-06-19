package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunosService {

    private final AlunosRepository alunosRepository;
    private final AlunosMapper alunosMapper;

    public AlunosService(AlunosMapper alunosMapper, AlunosRepository alunosRepository) {
        this.alunosMapper = alunosMapper;
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosDTO> listarAlunos(){
        List<AlunosModel> aluno = alunosRepository.findAll();
        return aluno.stream()
                .map(alunosMapper::map)
                .collect(Collectors.toList());
    }

    public AlunosDTO listarAlunoPorId(Long id){
        Optional<AlunosModel> alunoPorId = alunosRepository.findById(id);
        return alunoPorId.map(alunosMapper::map).orElse(null);
    }

    public AlunosDTO criarAluno(AlunosDTO alunoDto){
        AlunosModel aluno = alunosMapper.map(alunoDto);
        aluno =  alunosRepository.save(aluno);
        return alunosMapper.map(aluno);
    }

    public AlunosDTO atualizarAluno(Long id, AlunosDTO alunoDto){
        Optional<AlunosModel> alunoExiste = alunosRepository.findById(id);
        if(alunoExiste.isPresent()){
            AlunosModel alunoAtualizado = alunosMapper.map(alunoDto);
            alunoAtualizado.setId(id);
            AlunosModel alunoSalvo = alunosRepository.save(alunoAtualizado);
            return alunosMapper.map(alunoSalvo);
        }
        return null;
    }


    public void deletarAlunosPorId(Long id){
        alunosRepository.deleteById(id);
    }

}
