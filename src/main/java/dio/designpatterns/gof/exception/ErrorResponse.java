package dio.designpatterns.gof.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp; // Campo para armazenar a data e hora do erro
    private int status; // Campo para armazenar o código de status HTTP do erro
    private String error; // Campo para armazenar a mensagem de erro
    private String message; // Campo para armazenar uma mensagem detalhada sobre o erro
    private String path; // Campo para armazenar o caminho da requisição que causou o erro

    // Construtor para inicializar os campos da classe
    public ErrorResponse(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now(); // Define a data e hora do erro como o momento atual
        this.status = status; // Define o código de status HTTP do erro
        this.error = error; // Define a mensagem de erro
        this.message = message; // Define a mensagem detalhada sobre o erro
        this.path = path; // Define o caminho da requisição que causou o erro
    }

    // Getters e setters (necessssários para o Jackson converter JSON para objeto e vice-versa)
    public LocalDateTime getTimestamp() {  return timestamp;  }
    public void setTimestamp(LocalDateTime timestamp) {  this.timestamp = timestamp;    }

    public int getStatus() {  return status;   }
    public void setStatus(int status) {  this.status = status;   }

    public String getError() {  return error;   }
    public void setError(String error) {  this.error = error;    }

    public String getMessage() {  return message;   }
    public void setMessage(String message) {  this.message = message;   }

    public String getPath() {  return path;   }
    public void setPath(String path) {  this.path = path;   }
}
