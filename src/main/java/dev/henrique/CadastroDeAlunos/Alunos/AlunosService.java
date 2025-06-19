package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    private AlunosRepository alunosRepository;
    private AlunosMapper alunosMapper;

    public AlunosService(AlunosMapper alunosMapper, AlunosRepository alunosRepository) {
        this.alunosMapper = alunosMapper;
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosModel> listarAlunos(){
        return alunosRepository.findAll();
    }

    public AlunosModel listarAlunoPorId(Long id){
        Optional<AlunosModel> alunoPorId = alunosRepository.findById(id);
        return alunoPorId.orElse(null);
    }

    public AlunosDTO criarAluno(AlunosDTO alunoDto){
        AlunosModel aluno = alunosMapper.map(alunoDto);
        aluno =  alunosRepository.save(aluno);
        return alunosMapper.map(aluno);
    }

    public AlunosModel atualizarAluno(Long id, AlunosModel alunoAtualizado){
        if(alunosRepository.existsById(id)){
            alunoAtualizado.setId(id);
            return alunosRepository.save(alunoAtualizado);
        }
        return null;
    }


    public void deletarAlunosPorId(Long id){
        alunosRepository.deleteById(id);
    }

}
