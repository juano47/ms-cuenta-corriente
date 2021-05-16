package ms.cuenta.corriente.domain;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="pago")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private Integer id;

	@Column(name="fecha_pago")
	private Instant fechaPago;

	@OneToOne
	@JoinColumn(name = "id_medio")
	private MedioPago medio;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
}
