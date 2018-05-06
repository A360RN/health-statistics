package pe.unmsm.fisi.healthstats.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.datastore.Entity;

import pe.unmsm.fisi.healthstats.dao.HealthStatsDao;
import pe.unmsm.fisi.healthstats.dto.Stat;
import pe.unmsm.fisi.healthstats.service.HealthStatsService;

@Service
public class HealthStatsServiceImpl implements HealthStatsService {

	@Autowired
	private HealthStatsDao healthStatsDao;
	
	@Override
	public Map<String, Object> getHealthStats(Map<String, Object> filters) {
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		List<Stat> stats = new ArrayList<>();
		int total = 0;
		double valueTotal = 0;
		Iterator<Entity> entityIt = healthStatsDao.getHealthStats(null);
		while(entityIt.hasNext()) {
			Entity nextEntity = entityIt.next();
			Stat stat = new Stat();
			stat.setCountryCode(nextEntity.getString("countryCode"));
			stat.setCountryName(nextEntity.getString("countryName"));
			stat.setSeriesCode(nextEntity.getString("seriesCode"));
			stat.setSeriesName(nextEntity.getString("seriesName"));
			stat.setYear(nextEntity.getLong("year"));
			stat.setValue(nextEntity.getDouble("value"));
			valueTotal += stat.getValue();
			
			stats.add(stat);
		}
		total = stats.size();
		data.put("total", total);
		data.put("valueTotal", valueTotal);
		data.put("stats", stats);
		response.put("data", data);
		return response;
	}
 
}
