package sander.ToDo_List.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sander.ToDo_List.modelo.Tarefa;
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
