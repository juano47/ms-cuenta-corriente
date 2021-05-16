package ms.cuenta.corriente.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoDto {

    private Integer id;
    private String obra;
    private List<DetallePedidoDto> detallePedido;
    private String estadoPedido;
}
