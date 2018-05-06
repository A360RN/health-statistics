package pe.unmsm.fisi.healthstats.dao;

import java.util.Iterator;
import java.util.Map;

import com.google.cloud.datastore.Entity;

public interface HealthStatsDao {

	public Iterator<Entity> getHealthStats(Map<String, Object> filters);
}
