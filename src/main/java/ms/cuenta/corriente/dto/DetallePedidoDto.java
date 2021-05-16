package ms.cuenta.corriente.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePedidoDto {

    private Integer id;
    private Integer cantidad;
    private Double precio;
    private String producto;
    private Double precioUnitario;
}
