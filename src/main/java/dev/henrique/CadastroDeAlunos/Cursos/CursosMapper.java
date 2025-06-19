package dev.henrique.CadastroDeAlunos.Cursos;

import org.springframework.stereotype.Component;

@Component
public class CursosMapper {

    public CursosModel map(CursosDTO cursosDto){
            CursosModel cursosModel = new CursosModel();

            cursosModel.setId(cursosDto.getId());
            cursosModel.setNome(cursosDto.getNome());
            cursosModel.setCargaHoraria(cursosDto.getCargaHoraria());
            cursosModel.setValor(cursosDto.getValor());
            cursosModel.setModalidade(cursosDto.getModalidade());
            cursosModel.setDataInicio(cursosDto.getDataInicio());
            cursosModel.setDataFim(cursosDto.getDataFim());
            cursosModel.setDescricao(cursosDto.getDescricao());
            cursosModel.setAlunos(cursosDto.getAlunos());

        return cursosModel;
    }

    public CursosDTO map(CursosModel cursosModel){
        CursosDTO cursosDto = new CursosDTO();

        cursosDto.setId(cursosModel.getId());
        cursosDto.setNome(cursosModel.getNome());
        cursosDto.setCargaHoraria(cursosModel.getCargaHoraria());
        cursosDto.setValor(cursosModel.getValor());
        cursosDto.setModalidade(cursosModel.getModalidade());
        cursosDto.setDataInicio(cursosModel.getDataInicio());
        cursosDto.setDataFim(cursosModel.getDataFim());
        cursosDto.setDescricao(cursosModel.getDescricao());
        cursosDto.setAlunos(cursosModel.getAlunos());

        return cursosDto;
    }

}
