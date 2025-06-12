package sander.ToDo_List.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sander.ToDo_List.dto.TarefaDTO;
import sander.ToDo_List.modelo.Tarefa;
import sander.ToDo_List.service.TarefaService;

import java.util.List;

@RequestMapping("/tarefa")
@RestController
public class TarefaController {

     @Autowired
     private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity criarTarefa(@RequestBody TarefaDTO dto){
      return ResponseEntity.status(HttpStatus.CREATED)
              .body(tarefaService.criarTarefa(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity  carregarUnicaTarefa(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.carregarTarefa(id));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> list(){
        return ResponseEntity.ok(tarefaService.list());
    }

    @PutMapping("/{id}/update")
    public  ResponseEntity updateTarefa(@PathVariable Long id,@RequestBody TarefaDTO dto){
        return ResponseEntity.ok(tarefaService.updateTarefa(id,dto));
    }
    @PutMapping("/{id}/cancelar")
    public  ResponseEntity cancelarTarefa(@PathVariable Long id){
        return  ResponseEntity.ok(tarefaService.cancelarTarefa(id));
    }


}
