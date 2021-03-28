package com.example.data.sample.repo;

import java.util.List;

import com.example.data.sample.entities.CustomMetric;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Join.Type;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ANSI)
@Repository(value = "oltpDataSource")
public interface CustomMetricRepository extends CrudRepository<CustomMetric, Long> {
	
	@Executable
	/*
	 * @Query("select m.*,f.kpi_filter_ky as f_kpi_filter_ky, f.clnt_obj_id as f_clnt_obj_id,\n"
	 * +
	 * "f.kpi_obj_ky as f_kpi_obj_ky,f.filter_val as f_filter_val from t_kpi_obj m\n"
	 * + "left outer join t_kpi_filter f \n" +
	 * "on m.kpi_obj_ky=f.kpi_obj_ky and m.clnt_obj_id=f.clnt_obj_id\n" +
	 * "where m.clnt_obj_id=:clientObjectId")
	 */
	@Join(value = "filters", alias = "f_", type = Type.LEFT_FETCH)
	List<CustomMetric> findByClientObjectId(String clientObjectId);
}
