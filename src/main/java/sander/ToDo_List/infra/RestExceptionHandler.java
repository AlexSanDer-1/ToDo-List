package sander.ToDo_List.infra;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestErrorMessage> tratarError404(EntityNotFoundException ex){
          RestErrorMessage  capturaError = new RestErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(capturaError);
    }

    @ExceptionHandler(ValidacaoError.class)
    public ResponseEntity<RestErrorMessage> validacaoTarefa(ValidacaoError ex){
        RestErrorMessage  capturaError = new RestErrorMessage(HttpStatus.BAD_REQUEST,ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(capturaError);
    }

}
