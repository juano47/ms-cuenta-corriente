package ms.cuenta.corriente.service;

import ms.cuenta.corriente.domain.Pago;
import ms.cuenta.corriente.dto.PagoDto;

public interface PagoService {

    public PagoDto crear(PagoDto dtoPago) throws Exception;
}
