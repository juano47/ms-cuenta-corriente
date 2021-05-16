package ms.cuenta.corriente.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@DiscriminatorValue("2")
public class Efectivo extends MedioPago {

	@Column(name = "nro_recibo")
	private Integer nroRecibo;
}
