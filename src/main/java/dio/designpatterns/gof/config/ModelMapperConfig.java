package dio.designpatterns.gof.config;

import dio.designpatterns.gof.dto.ClientResponseDTO;
import dio.designpatterns.gof.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Regra customizada: Cliente -> ClienteResponseDTO
        modelMapper.createTypeMap(Cliente.class, ClientResponseDTO.class)
            .addMappings(mapper -> {
                // Pega o numero do Cliente e joga no Endereco do DTO
                mapper.map(Cliente::getNumero, (dest, v) -> dest.getEndereco().setNumero((String) v));
            });

        return modelMapper;
    }
}