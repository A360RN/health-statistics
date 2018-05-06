package pe.unmsm.fisi.healthstats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.unmsm.fisi.healthstats.dto.Stat;

@RestController
public class StatsController {

	@GetMapping("/api/v1/stats/health")
	public Stat getHealthStats() {
		Stat stat = new Stat();
		stat.setCountryCode("ARG");
		stat.setValue(15000.00);
		return stat;
	}
}
