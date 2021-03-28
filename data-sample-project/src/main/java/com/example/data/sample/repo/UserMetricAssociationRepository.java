package com.example.data.sample.repo;

import java.util.List;

import com.example.data.sample.entities.UserMetricAssociation;
import com.example.data.sample.entities.UserMetricAssociationId;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Join.Type;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ANSI)
@Repository(value = "oltpDataSource")
public interface UserMetricAssociationRepository
		extends CrudRepository<UserMetricAssociation, UserMetricAssociationId> {

	/*
	 * @Query("select u.*, \n" +
	 * "m.kpi_obj_ky as m_kpi_obj_ky, m.kpi_ovrd_nm as m_kpi_ovrd_nm, m.clnt_obj_id as m_clnt_obj_id, \n"
	 * +
	 * "f.kpi_filter_ky as f_kpi_filter_ky, f.kpi_obj_ky as f_kpi_obj_ky, f.clnt_obj_id as f_clnt_obj_id, \n"
	 * + "f.filter_val as f_filter_val\n" + "from t_usr_kpi_obj_accs u\n" +
	 * "inner join t_kpi_obj m on u.kpi_obj_ky=m.kpi_obj_ky and u.clnt_obj_id=m.clnt_obj_id\n"
	 * +
	 * "left outer join t_kpi_filter f on m.kpi_obj_ky=f.kpi_obj_ky and m.clnt_obj_id=f.clnt_obj_id\n"
	 * + "where u.clnt_obj_id=:clientObjectId and u.usr_ao_id=:userAOId")
	 */
	@Join(value = "metric", alias = "m_")
	@Join(value = "metric.filters", alias = "f_", type = Type.LEFT_FETCH)
	List<UserMetricAssociation> findByClientObjectIdAndUserMetricAssociationIdUserAOId(String clientObjectId, String userAOId);
}
