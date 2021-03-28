package ms.cuenta.corriente.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Efectivo extends MedioPago {
	private Integer nroRecibo;
}
