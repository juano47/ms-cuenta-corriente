package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cheque extends MedioPago{

	private Integer nroCheque;
	private Instant fechaCobro;
	private String banco;

}
