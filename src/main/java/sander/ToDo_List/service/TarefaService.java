package sander.ToDo_List.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sander.ToDo_List.dto.TarefaDTO;
import sander.ToDo_List.modelo.Status;
import sander.ToDo_List.modelo.Tarefa;
import sander.ToDo_List.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;


    private  List<Tarefa> list(){
      Sort sort = Sort.by(Sort.Direction.DESC,"prioridade")
                .and(Sort.by(Sort.Direction.ASC,"id"));
     return repository.findAll(sort);
    }


    private  Tarefa carregarTarefa(Long id){
         return  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    private List<Tarefa> criarTarefa(TarefaDTO dto){
        Tarefa tarefa = new Tarefa(dto);
        tarefa.setStatus(Status.REALIZADO);
        repository.save(tarefa);
        return list();
    }
    private List<Tarefa> updateTarefa(Long id,TarefaDTO dto){

       Tarefa tarefaUp =  carregarTarefa(id);

       tarefaUp.setNome(dto.nome());
       tarefaUp.setDescricao(dto.descricao());
       tarefaUp.setPrioridade(dto.prioridade());

        repository.save(tarefaUp);
        return list();
    }
    private List<Tarefa> cancelarTarefa(Long id){

         Tarefa tarefa = carregarTarefa(id);
         tarefa.setStatus(Status.CANCELADO);

         repository.save(tarefa);
         return list();
    }
}
