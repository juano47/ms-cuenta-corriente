package ms.cuenta.corriente.service.impl;

import ms.cuenta.corriente.dao.PagoRepository;
import ms.cuenta.corriente.domain.*;
import ms.cuenta.corriente.dto.PagoDto;
import ms.cuenta.corriente.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Override
    public PagoDto crear(PagoDto pagoDto) throws Exception {

        Pago nuevo= new Pago();

        switch (pagoDto.getTipoPago()){
            case 1:
                Transferencia transferencia= new Transferencia();
                transferencia.setCodigoTransferencia(pagoDto.getCodigoTransferencia());
                transferencia.setObservacion(pagoDto.getObservacion());
                transferencia.setCbuOrigen(pagoDto.getCbuOrigen());
                transferencia.setCbuDestino(pagoDto.getCbuDestino());
                nuevo.setMedio(transferencia);
                break;
            case 2:
                Efectivo efectivo= new Efectivo();
                efectivo.setObservacion(pagoDto.getObservacion());
                efectivo.setNroRecibo(pagoDto.getNroRecibo());
                nuevo.setMedio(efectivo);
                break;
            case 3:
                Cheque cheque= new Cheque();
                cheque.setObservacion(pagoDto.getObservacion());
                cheque.setNroCheque(pagoDto.getNroCheque());
                cheque.setBanco(pagoDto.getBanco());
                cheque.setFechaCobro(pagoDto.getFechaCobro());
                break;
        }

        Cliente cliente=new Cliente();
        cliente.setId(pagoDto.getClienteDto().getId());
        cliente.setCuit(pagoDto.getClienteDto().getCuit());
        cliente.setMail(pagoDto.getClienteDto().getMail());
        cliente.setRazonSocial(pagoDto.getClienteDto().getRazonSocial());

        nuevo.setCliente(cliente);
        nuevo.setFechaPago(Instant.now());

        pagoRepository.save(nuevo);
        return pagoDto;
    }
}
