package com.api.alunos.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Problema {

    private LocalDateTime hora;
    private String mensagem;
}
