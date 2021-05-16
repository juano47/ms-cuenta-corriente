package ms.cuenta.corriente.service.impl;

import ms.cuenta.corriente.dto.DetallePedidoDto;
import ms.cuenta.corriente.dto.PedidoDto;
import ms.cuenta.corriente.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Override
    public List<PedidoDto> obtenerListaPedidos(Integer idCliente) {
        List<PedidoDto> listaPedido = new ArrayList<>();
        List<DetallePedidoDto> detallePedidoDtos= new ArrayList<>();
        DetallePedidoDto dp= new DetallePedidoDto();
        dp.setId(3);
        dp.setCantidad(20);
        dp.setPrecioUnitario(5.0);
        dp.setPrecio(dp.getCantidad()*dp.getPrecioUnitario());
        dp.setProducto("Hormigon");
        detallePedidoDtos.add(dp);

        PedidoDto pedidoDto= new PedidoDto();
        pedidoDto.setEstadoPedido("ACEPTADO");
        pedidoDto.setObra("200 Viviendas");
        pedidoDto.setDetallePedido(detallePedidoDtos);
        pedidoDto.setId(2);

        listaPedido.add(pedidoDto);
        return listaPedido;
    }
}
