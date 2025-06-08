package sander.ToDo_List.infra;
public class ValidacaoError extends RuntimeException {
    public ValidacaoError(String message) {
        super(message);
    }
}
