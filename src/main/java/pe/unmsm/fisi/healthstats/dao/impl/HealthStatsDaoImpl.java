package pe.unmsm.fisi.healthstats.dao.impl;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

import pe.unmsm.fisi.healthstats.dao.HealthStatsDao;

@Repository
public class HealthStatsDaoImpl implements HealthStatsDao {

	private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

	@Override
	public Iterator<Entity> getHealthStats(Map<String, Object> filters) {
		System.out.println(filters);
		String countryCode = (String) filters.get("countryCode");
		Integer year = (Integer) filters.get("year");
		Query<Entity> query;
		if (!countryCode.equals("") && year > -1) {
			System.out.println("dos");
			query = Query
					.newEntityQueryBuilder().setKind("HealthStat").setFilter(CompositeFilter
							.and(PropertyFilter.eq("countryCode", countryCode), PropertyFilter.eq("year", year)))
					.build();
		} else if (!countryCode.equals("")) {
			System.out.println("cc");
			query = Query.newEntityQueryBuilder().setKind("HealthStat")
					.setFilter(PropertyFilter.eq("countryCode", countryCode)).build();
		} else if (year > -1) {
			System.out.println("year");
			query = Query.newEntityQueryBuilder().setKind("HealthStat").setFilter(PropertyFilter.eq("year", year))
					.build();
		} else {
			System.out.println("0");
			query = Query.newEntityQueryBuilder().setKind("HealthStat").build();
		}
		return datastore.run(query);
	}

}
