package sander.ToDo_List.modelo;

import jakarta.persistence.*;
import lombok.*;
import sander.ToDo_List.dto.TarefaDTO;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Status status;
    private String prioridade;


    public Tarefa(TarefaDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.prioridade = dto.prioridade();
    }

    public Tarefa(String nome, String descricao, Status status, String prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = Status.PENDENTE;
        this.prioridade = prioridade;
    }
}
