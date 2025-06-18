package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    private AlunosRepository alunosRepository;

    public AlunosService(AlunosRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosModel> listarAlunos(){
        return alunosRepository.findAll();
    }

    public AlunosModel listarAlunoPorId(Long id){
        Optional<AlunosModel> alunoPorId = alunosRepository.findById(id);
        return alunoPorId.orElse(null);
    }

    public AlunosModel criarAluno(AlunosModel aluno){
        return alunosRepository.save(aluno);
    }

}
