-- V2: Migrations para adicionar a coluna de descricao na tabela de cursos

ALTER TABLE tb_cursos
ADD COLUMN descricao VARCHAR(255);