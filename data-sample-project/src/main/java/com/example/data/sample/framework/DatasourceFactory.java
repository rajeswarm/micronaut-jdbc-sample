package com.example.data.sample.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
class DatasourceFactory {

	private static Map<String, String> clientSchemaMap = new HashMap<>();
	private static Map<String, HikariDataSource> dataSourceMap = new ConcurrentHashMap<>();

	static {
		clientSchemaMap.put("CLIENT_A", "adpidmcore10_oltp");
		clientSchemaMap.put("CLIENT_B", "adpidmcore10_oltp");
		clientSchemaMap.put("CLIENT_C", "adpidmcore11_oltp");
		clientSchemaMap.put("CLIENT_D", "adpidmcore11_oltp");
	}

	static HikariDataSource getCurrentDataSource(RequestContext requestContext) {
		String schemaName = clientSchemaMap.get(requestContext.getClientObjectId());
		if (dataSourceMap.containsKey(schemaName)) {
			return dataSourceMap.get(schemaName);
		}

		HikariDataSource dataSource = createNewDataSource(schemaName);
		dataSourceMap.put(schemaName, dataSource);
		return dataSource;
	}

	@Bean
	@Named("oltpDataSource")
	public DataSource getOLTPDataSource(ApplicationContext applicationContext){
		return new MultiTenantDataSource(applicationContext);
	}

	private static HikariDataSource createNewDataSource(String schemaName) {
		final HikariDataSource ds = new HikariDataSource();
		ds.setPoolName(schemaName);
		ds.setMaximumPoolSize(10);
		ds.setJdbcUrl("jdbc:postgresql://localhost:5433/adpdc_oltp?currentSchema=" + schemaName);
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		return ds;
	}
}
