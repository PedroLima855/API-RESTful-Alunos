package com.api.alunos.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Problema {

    private LocalDateTime hora;
    private String mensagem;
}
