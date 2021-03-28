package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pago {

	private Integer id;
	private Cliente cliente;
	private Instant fechaPago;
	private MedioPago medio;
}
