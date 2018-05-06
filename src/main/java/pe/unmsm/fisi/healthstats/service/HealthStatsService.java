package pe.unmsm.fisi.healthstats.service;

import java.util.Map;

public interface HealthStatsService {

	public Map<String, Object> getHealthStats(Map<String, Object> filters);
}
