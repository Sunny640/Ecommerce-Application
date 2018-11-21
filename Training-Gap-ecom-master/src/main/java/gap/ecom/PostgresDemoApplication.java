package gap.ecom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
//@ComponentScan({"gap.ecom.inventory","gap.ecom.item","gap.ecom.order","gap.ecom.repositories"})
@EnableJpaAuditing

@SpringBootApplication(scanBasePackages={"gap.ecom.inventory","gap.ecom.item","gap.ecom.order","gap.ecom.repositories","gap.ecom.payment","gap.ecom.user"})
public class PostgresDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}
}
