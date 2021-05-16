package ms.cuenta.corriente.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private Integer id;
    private String razonSocial;
    private String cuit;
    private String mail;
}
