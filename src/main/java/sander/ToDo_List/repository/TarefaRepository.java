package sander.ToDo_List.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sander.ToDo_List.modelo.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
