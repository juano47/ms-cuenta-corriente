package ms.cuenta.corriente.service.impl;

import ms.cuenta.corriente.controller.PagoController;
import ms.cuenta.corriente.dao.PagoRepository;
import ms.cuenta.corriente.domain.*;
import ms.cuenta.corriente.dto.ClienteDto;
import ms.cuenta.corriente.dto.EstadoDto;
import ms.cuenta.corriente.dto.PagoDto;
import ms.cuenta.corriente.dto.PedidoDto;
import ms.cuenta.corriente.service.ClienteService;
import ms.cuenta.corriente.service.PagoService;
import ms.cuenta.corriente.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    PedidoService pedidoService;

    private final Logger log= LoggerFactory.getLogger(PagoServiceImpl.class);

    @Override
    public PagoDto crear(PagoDto pagoDto) throws Exception {

        Pago nuevo= new Pago();

        switch (pagoDto.getTipoPago()){
            case 1:
                log.info("TRANSFERENCIA");
                Transferencia transferencia= new Transferencia();
                transferencia.setCodigoTransferencia(pagoDto.getCodigoTransferencia());
                transferencia.setObservacion(pagoDto.getObservacion());
                transferencia.setCbuOrigen(pagoDto.getCbuOrigen());
                transferencia.setCbuDestino(pagoDto.getCbuDestino());
                nuevo.setMedio(transferencia);
                break;
            case 2:
                log.info("EFECTIVO");
                Efectivo efectivo= new Efectivo();
                efectivo.setObservacion(pagoDto.getObservacion());
                efectivo.setNroRecibo(pagoDto.getNroRecibo());
                nuevo.setMedio(efectivo);
                break;
            case 3:
                log.info("CHEQUE");
                Cheque cheque= new Cheque();
                cheque.setObservacion(pagoDto.getObservacion());
                cheque.setNroCheque(pagoDto.getNroCheque());
                cheque.setBanco(pagoDto.getBanco());
                cheque.setFechaCobro(pagoDto.getFechaCobro());
                break;
        }
        ClienteDto clienteDto= clienteService.obtenerCliente(pagoDto.getIdCliente());
        log.info("CLIENTE: "+pagoDto.getIdCliente());
        Cliente cliente=new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setCuit(clienteDto.getCuit());
        cliente.setMail(clienteDto.getMail());
        cliente.setRazonSocial(clienteDto.getRazonSocial());
        nuevo.setCliente(cliente);
        nuevo.setFechaPago(Instant.now());

        pagoRepository.save(nuevo);
        return pagoDto;
    }

    @Override
    public EstadoDto consultarEstado(Integer idCliente) throws Exception {
        List<PedidoDto> listaPedio= pedidoService.obtenerListaPedidos(idCliente);

        log.info("pedidos: "+listaPedio);
        Optional<List<Pago>> pagos= pagoRepository.findPagoByCliente_Id(idCliente);
        List<PagoDto> listaPagos= new ArrayList<>();

        for(Pago p: pagos.get()){
            log.info("pago: "+p);
            PagoDto dto= new PagoDto();
            dto.setId(p.getId());
            dto.setObservacion(p.getMedio().getObservacion());
            dto.setIdCliente(p.getCliente().getId());
            listaPagos.add(dto);
        }

        EstadoDto estadoDto= new EstadoDto();
        estadoDto.setListaPedido(listaPedio);
        estadoDto.setListaPago(listaPagos);

        log.info("ESTADO CUENTA: "+estadoDto);
        return estadoDto;
    }
}
