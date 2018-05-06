package pe.unmsm.fisi.HealthStatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealthStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthStatisticsApplication.class, args);
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello Spring";
	}
}
