package sander.ToDo_List.dto;

import jakarta.validation.constraints.NotBlank;

public record TarefaDTO(
        @NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "A descrição é obrigatório") String descricao,
        @NotBlank(message = "A prioridade é obrigatória") String prioridade) {
}
