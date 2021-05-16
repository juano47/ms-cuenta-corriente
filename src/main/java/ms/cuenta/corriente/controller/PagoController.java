package ms.cuenta.corriente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import ms.cuenta.corriente.dto.EstadoDto;
import ms.cuenta.corriente.dto.PagoDto;
import ms.cuenta.corriente.service.PagoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ms.cuenta.corriente.domain.Pago;

@RestController
@RequestMapping("api/pago")
public class PagoController {

	@Autowired
	PagoService pagoService;

	private final Logger log= LoggerFactory.getLogger(PagoController.class);

	@PostMapping
	public ResponseEntity<PagoDto> crear(@RequestBody PagoDto nuevo) {

		log.info("Nuevo Pago: "+nuevo);
		try {
			pagoService.crear(nuevo);
		} catch (Exception e) {
			log.error("ERROR AL CREAR PAGO: "+e.getMessage());
			return ResponseEntity.badRequest().build();
		}
		log.info("SE CREO CON EXITO EL PAGO");
		return ResponseEntity.ok(nuevo);
	}

	@GetMapping("/estadoCuenta/{id}")
	public ResponseEntity<EstadoDto> consultarEstado(@PathVariable Integer id){
		log.info("CONSULTA DE ESTADO CLIENTE ID: "+id);
		try {
			EstadoDto estadoDto= pagoService.consultarEstado(id);
			log.info("ESTADO: "+estadoDto);
			return ResponseEntity.ok(estadoDto);
		} catch (Exception e) {
			log.error("ERROR AL CONSULTAR EL ESTADO"+e.getMessage());
			return ResponseEntity.status(500).build();
		}
	}

}
