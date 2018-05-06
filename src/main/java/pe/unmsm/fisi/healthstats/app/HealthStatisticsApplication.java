package pe.unmsm.fisi.healthstats.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"pe.unmsm.fisi.healthstats"})
public class HealthStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthStatisticsApplication.class, args);
	}
}
