package ms.cuenta.corriente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MsCuentaCorrienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCuentaCorrienteApplication.class, args);
    }

}
