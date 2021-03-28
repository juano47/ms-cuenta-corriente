package ms.cuenta.corriente.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transferencia extends MedioPago{

	private String cbuOrigen;
	private String cbuDestino;
	private Long codigoTransferencia;
}
