package ms.cuenta.corriente.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PagoDto {

    private Integer id;
    private String observacion;
    private String cbuOrigen;
    private String cbuDestino;
    private Long codigoTransferencia;
    private Integer nroRecibo;
    private Integer nroCheque;
    private Instant fechaCobro;
    private String banco;
    private Integer tipoPago;
    private Integer idCliente;
}
