package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunosService {

    private AlunosRepository alunosRepository;

    public AlunosService(AlunosRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosModel> listarAlunos(){
        return alunosRepository.findAll();
    }

}
