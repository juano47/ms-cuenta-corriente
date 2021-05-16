package ms.cuenta.corriente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import ms.cuenta.corriente.dto.PagoDto;
import ms.cuenta.corriente.service.PagoService;
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

	@PostMapping
	public ResponseEntity<PagoDto> crear(@RequestBody PagoDto nuevo) {
		try {
			pagoService.crear(nuevo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(nuevo);
	}


}
