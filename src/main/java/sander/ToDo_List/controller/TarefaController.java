package sander.ToDo_List.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sander.ToDo_List.dto.TarefaDTO;
import sander.ToDo_List.service.TarefaService;

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

}
