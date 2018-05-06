package pe.unmsm.fisi.healthstats.service;

import java.util.List;
import java.util.Map;

import pe.unmsm.fisi.healthstats.dto.Stat;

public interface HealthStatsService {

	public List<Stat> getHealthStats(Map<String, Object> filters);
}
