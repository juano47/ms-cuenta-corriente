package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@DiscriminatorValue("3")
public class Cheque extends MedioPago{

	@Column(name="nro_cheque")
	private Integer nroCheque;
	@Column(name = "fecha_cobro")
	private Instant fechaCobro;
	@Column(name = "banco")
	private String banco;

}
