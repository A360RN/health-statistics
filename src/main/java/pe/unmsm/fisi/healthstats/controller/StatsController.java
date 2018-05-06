package pe.unmsm.fisi.healthstats.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.unmsm.fisi.healthstats.service.HealthStatsService;

@RestController
public class StatsController {
	
	@Autowired
	private HealthStatsService healthStatsService;

	@GetMapping("/api/v1/stats/health")
	public Map<String, Object> getHealthStats() {
		return healthStatsService.getHealthStats(null);
	}
}
