package ms.cuenta.corriente.service;

import ms.cuenta.corriente.dto.PedidoDto;

import java.util.List;

public interface PedidoService {

    public List<PedidoDto> obtenerListaPedidos(Integer idCliente);
}
