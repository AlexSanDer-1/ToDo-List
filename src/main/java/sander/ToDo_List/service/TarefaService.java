package sander.ToDo_List.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sander.ToDo_List.dto.TarefaDTO;
import sander.ToDo_List.dto.TarefaUP;
import sander.ToDo_List.infra.ValidacaoError;
import sander.ToDo_List.modelo.Status;
import sander.ToDo_List.modelo.Tarefa;
import sander.ToDo_List.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;


    public   List<Tarefa> list(){
      Sort sort = Sort.by(Sort.Direction.DESC,"prioridade")
                .and(Sort.by(Sort.Direction.ASC,"id"));
     return repository.findAll(sort);
    }


    public   Tarefa carregarTarefa(Long id){
         return  repository.findById(id)
                .orElseThrow(() -> new ValidacaoError("Tarefa não encontrada"));
    }

    public List<Tarefa> criarTarefa(TarefaDTO dto){
        Tarefa tarefa = new Tarefa(dto);
        tarefa.setStatus(Status.REALIZADO);
        repository.save(tarefa);
        return list();
    }
    public List<Tarefa> updateTarefa(Long id, TarefaUP up){

       Tarefa tarefaEntity =  carregarTarefa(id);
       Tarefa tarefaAtualizada = Tarefa.builder()
               .id(tarefaEntity.getId())
               .nome(up.nome() != null ? up.nome() : tarefaEntity.getNome())
               .descricao(up.descricao() != null ? up.descricao() : tarefaEntity.getDescricao())
               .prioridade(up.prioridade() != null ? up.prioridade() : tarefaEntity.getPrioridade())
               .build();

        repository.save(tarefaAtualizada);
        return list();
    }
    public List<Tarefa> cancelarTarefa(Long id){

         Tarefa tarefa = carregarTarefa(id);
         tarefa.setStatus(Status.CANCELADO);

         repository.save(tarefa);
         return list();
    }
}
