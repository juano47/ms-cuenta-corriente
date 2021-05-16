package ms.cuenta.corriente.dao;

import ms.cuenta.corriente.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    Optional<List<Pago>> findPagoByCliente_Id(Integer idCliente);
}
