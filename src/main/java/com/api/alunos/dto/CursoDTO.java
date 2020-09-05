package com.api.alunos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Long id;
    private String nomeCurso;
    private Boolean ativo;

}
