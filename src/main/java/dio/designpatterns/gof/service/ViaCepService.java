package dio.designpatterns.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dio.designpatterns.gof.model.Endereco;

/**
 * Cliente Http, criado via <b>OpenFeign</b>, para consumir a API do <b>ViaCep</b>. Com isso, podemos consultar os dados de um endereço a partir do CEP. 
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br/">ViaCep</a
 * @author moiseslemosz
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
