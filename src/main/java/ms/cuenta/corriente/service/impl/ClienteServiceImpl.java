package ms.cuenta.corriente.service.impl;

import ms.cuenta.corriente.dto.ClienteDto;
import ms.cuenta.corriente.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public ClienteDto obtenerCliente(Integer idCliente) {
        ClienteDto clienteDto= new ClienteDto();
        clienteDto.setId(idCliente);
        clienteDto.setCuit("123456789");
        clienteDto.setRazonSocial("Hola SRL");
        clienteDto.setMail("ejemplo@hola.com");
        return clienteDto;
    }
}
