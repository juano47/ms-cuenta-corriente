package ms.cuenta.corriente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@DiscriminatorValue("1")
public class Transferencia extends MedioPago{

	@Column(name = "cbu_origen")
	private String cbuOrigen;
	@Column(name = "cbu_destino")
	private String cbuDestino;
	@Column(name = "codigo_transferencia")
	private Long codigoTransferencia;
}
