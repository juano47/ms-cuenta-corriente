package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "usr_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;
	@Column(name = "razon_social")
	private String razonSocial;
	@Column(name = "cuit")
	private String cuit;
	@Column(name = "mail")
	private String mail;

}
