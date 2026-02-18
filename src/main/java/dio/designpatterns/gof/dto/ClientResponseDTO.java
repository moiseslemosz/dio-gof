package dio.designpatterns.gof.dto;

public class ClientResponseDTO {
    private String nome;
    private EnderecoResponseDTO endereco; // Usamos o DTO de resposta para o endereço, que tem os campos que queremos expor

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public EnderecoResponseDTO getEndereco() { return endereco; }
    public void setEndereco(EnderecoResponseDTO endereco) { this.endereco = endereco; }
}