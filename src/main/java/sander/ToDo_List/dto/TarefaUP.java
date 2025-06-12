package sander.ToDo_List.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaUP(String nome,String descricao,String prioridade) {
}
