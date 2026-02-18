package dio.designpatterns.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



/* 
 * Projeto Spring Boot gerado via Spring Initializr (https://start.spring.io/) com as seguintes dependências/módulos:
 * - Spring Web
 * - Spring Data JPA
 * - H2 Database
 * - OpenFeign
 *    
 * @author moiseslemoz
 */

@EnableFeignClients
@SpringBootApplication
public class GofApplication {

	public static void main(String[] args) {
		SpringApplication.run(GofApplication.class, args);
	}

}
