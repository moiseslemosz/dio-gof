package dio.designpatterns.gof.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Os atributos desse modelo foram gerados automaticamente a partir do JSON de resposta da API ViaCEP (https://viacep.com.br/) 
 * utilizando a ferramenta online https://jsonschema2pojo,org e adaptados para o formato de entidade JPA.
 * Modelo de entidade Endereco para persistência em banco de dados via Spring Data JPA.
 * 
 * @see <a href="https://viacep.com.br/">ViaCEP</a> 
 * @see <a href="https://jsonschema2pojo.org/">jsonschema2pojo</a>
 * 
 * @author moiseslemoz
 */


@Entity
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String cidade;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getLocalidade() { return localidade; }
    public void setLocalidade(String localidade) { this.localidade = localidade; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getRegiao() { return regiao; }
    public void setRegiao(String regiao) { this.regiao = regiao; }
    public String getIbge() { return ibge; }
    public void setIbge(String ibge) { this.ibge = ibge; }
    public String getGia() { return gia; }
    public void setGia(String gia) { this.gia = gia; }
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public String getSiafi() { return siafi; }
    public void setSiafi(String siafi) { this.siafi = siafi; }
}
