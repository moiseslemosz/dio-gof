package dio.designpatterns.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa tudo de web
import org.modelmapper.ModelMapper;

import dio.designpatterns.gof.dto.ClientRequestDTO;
import dio.designpatterns.gof.dto.ClientResponseDTO;
import dio.designpatterns.gof.service.ClienteService;
import dio.designpatterns.gof.model.Cliente;
import dio.designpatterns.gof.model.Endereco;

import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> buscarTodos() {
        List<ClientResponseDTO> clientesDTO = StreamSupport.stream(clienteService.buscarTodos().spliterator(), false)
                .map(cliente -> modelMapper.map(cliente, ClientResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(modelMapper.map(cliente, ClientResponseDTO.class));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> inserir(@RequestBody ClientRequestDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        
        // Mantemos sua lógica manual do endereço (Perfeito!)
        Endereco endereco = new Endereco();
        endereco.setCep(clienteDTO.getCep());
        endereco.setNumero(clienteDTO.getNumero());
        cliente.setEndereco(endereco);

        clienteService.inserir(cliente);

        return ResponseEntity.ok(modelMapper.map(cliente, ClientResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> atualizar(@PathVariable Long id, @RequestBody ClientRequestDTO clienteDTO) {
        // 1. Convertemos DTO -> Entidade
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        
        // 2. IMPORTANTE: Forçamos o ID no objeto para o JPA entender que é UPDATE
        // Se não fizer isso, ele cria um novo registro!
        cliente.setId(id); 

        // 3. Ajuste manual do Endereço (igual ao POST)
        Endereco endereco = new Endereco();
        endereco.setCep(clienteDTO.getCep());
        endereco.setNumero(clienteDTO.getNumero());
        cliente.setEndereco(endereco);

        // 4. Chamamos o service. 
        // Se o ID não existir, o Service (que ajustamos antes) ou o erro global vai avisar.
        clienteService.atualizar(id, cliente);

        return ResponseEntity.ok(modelMapper.map(cliente, ClientResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}