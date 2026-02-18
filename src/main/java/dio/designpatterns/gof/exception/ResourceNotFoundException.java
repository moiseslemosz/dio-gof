package dio.designpatterns.gof.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Anotação para indicar que esta exceção deve retornar um status HTTP 404 (Not Found)
public class ResourceNotFoundException extends RuntimeException { // A classe estende RuntimeException, o que significa que é uma exceção não verificada
    public ResourceNotFoundException(String message) {
        super(message); // Chama o construtor da classe pai (RuntimeException) para definir a mensagem de erro
    }
}
