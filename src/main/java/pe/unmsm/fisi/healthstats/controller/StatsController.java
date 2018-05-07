package pe.unmsm.fisi.healthstats.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.unmsm.fisi.healthstats.service.HealthStatsService;

@RestController
public class StatsController {
	
	@Autowired
	private HealthStatsService healthStatsService;

	@GetMapping("/api/v1/stats/health")
	public Map<String, Object> getHealthStats(
			@RequestParam(name="countryCode", defaultValue="") String countryCode,
			@RequestParam(name="year", defaultValue="-1") Integer year,
			@RequestParam(name="seriesCode", defaultValue="") String seriesCode) {
		Map<String, Object> params = new HashMap<>();
		params.put("countryCode", countryCode);
		params.put("year", year);
		params.put("seriesCode", seriesCode);
		return healthStatsService.getHealthStats(params);
	}
}
