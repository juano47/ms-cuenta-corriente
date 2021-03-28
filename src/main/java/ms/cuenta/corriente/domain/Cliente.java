package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
	private Integer id;
	private String razonSocial;
	private String cuit;
	private String mail;

}
