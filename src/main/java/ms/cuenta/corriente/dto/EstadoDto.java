package ms.cuenta.corriente.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstadoDto {

    List<PagoDto> listaPago;
    List<PedidoDto> listaPedido;
}
