package dio.designpatterns.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dio.designpatterns.gof.model.Cliente;
import dio.designpatterns.gof.service.ClienteService;
import dio.designpatterns.gof.model.ClienteRepository;
import dio.designpatterns.gof.model.Endereco;
import dio.designpatterns.gof.model.EnderecoRepository;
import dio.designpatterns.gof.service.ViaCepService;
import dio.designpatterns.gof.exception.ResourceNotFoundException;

/**
 * Implementação concreta da interface {@link ClienteService}. Aqui, devemos colocar a lógica de negócio
 * para cada um dos métodos definidos na interface. Por enquanto, os métodos estão com o corpo vazio, mas
 * em uma aplicação real, eles conteriam a lógica necessária para realizar as operações de CRUD (Create, Read, Update, Delete)
 * para os clientes.
 * 
 * @author moiseslemosz
 */

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; // Injeção de dependência do repositório para acessar os dados dos clientes
    @Autowired
    private EnderecoRepository enderecoRepository; // Injeção de dependência do repositório para acessar os dados dos endereços
    @Autowired
    private ViaCepService viaCepService; // Injeção de dependência do serviço para acessar os dados dos endereços via CEP

    @Override
    public Iterable<Cliente> buscarTodos() {  return clienteRepository.findAll();  }

    @Override
    public Cliente buscarPorId(Long id) { return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));  }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id); // Verifica se o cliente com o ID fornecido existe no repositório
        if (clienteExistente.isPresent()) {
            cliente.setId(id); // Define o ID do cliente para garantir que estamos atualizando o cliente correto

            salvarClienteComCep(cliente); // Chama o método privado para salvar o cliente com o endereço atualizado
        }
        
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id); // Deleta o cliente com o ID fornecido do repositório
        
    }

    // Método privado para salvar o cliente com o endereço atualizado
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep(); // Obtém o CEP do endereço do cliente
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep); // Consulta o serviço ViaCEP para obter os dados do endereço
            enderecoRepository.save(novoEndereco); // Salva o novo endereço no repositório
            return novoEndereco; 
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
