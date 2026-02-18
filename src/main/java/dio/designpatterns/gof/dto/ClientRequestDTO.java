package dio.designpatterns.gof.dto;

public class ClientRequestDTO {
    private String nome;
    private String cep; // O usuário só manda o CEP e número da casa, a gente se vira com o resto
    private String numero;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}