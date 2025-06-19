package dev.henrique.CadastroDeAlunos.Alunos;

import org.springframework.stereotype.Component;

@Component
public class AlunosMapper {

    public AlunosModel map(AlunosDTO alunosDto){
        AlunosModel alunosModel = new AlunosModel();

        alunosModel.setId(alunosDto.getId());
        alunosModel.setNome(alunosDto.getNome());
        alunosModel.setEmail(alunosDto.getEmail());
        alunosModel.setIdade(alunosDto.getIdade());
        alunosModel.setEndereco(alunosDto.getEndereco());
        alunosModel.setCpf(alunosDto.getCpf());
        alunosModel.setTelefone(alunosDto.getTelefone());
        alunosModel.setCursos(alunosDto.getCursos());

        return alunosModel;
    }

    public AlunosDTO map(AlunosModel alunosModel){
        AlunosDTO alunosDto = new AlunosDTO();

        alunosDto.setId(alunosModel.getId());
        alunosDto.setNome(alunosModel.getNome());
        alunosDto.setEmail(alunosModel.getEmail());
        alunosDto.setIdade(alunosModel.getIdade());
        alunosDto.setEndereco(alunosModel.getEndereco());
        alunosDto.setCpf(alunosModel.getCpf());
        alunosDto.setTelefone(alunosModel.getTelefone());
        alunosDto.setCursos(alunosModel.getCursos());

        return alunosDto;
    }

}
