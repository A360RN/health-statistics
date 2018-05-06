package pe.unmsm.fisi.healthstats.dao.impl;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;

import pe.unmsm.fisi.healthstats.dao.HealthStatsDao;

@Repository
public class HealthStatsDaoImpl implements HealthStatsDao {

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	
	@Override
	public Iterator<Entity> getHealthStats(Map<String, Object> filters) {
		Query<Entity> query = 
				Query.newEntityQueryBuilder().setKind("HealthStat").build();
		return datastore.run(query);
	}

}
