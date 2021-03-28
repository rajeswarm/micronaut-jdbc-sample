package com.example.data.sample.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_kpi_obj")
public class CustomMetric {

	@Id
	@Column(name = "kpi_obj_ky")
	private Long metricId;
	
	@Column(name = "clnt_obj_id")
	private String clientObjectId;
	
	@Column(name = "kpi_ovrd_nm")
	private String overrideName;
	
	@OneToMany(mappedBy = "metric")
	private List<MetricFilter> filters;

	public List<MetricFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<MetricFilter> filters) {
		this.filters = filters;
	}

	public String getClientObjectId() {
		return clientObjectId;
	}

	public void setClientObjectId(String clientObjectId) {
		this.clientObjectId = clientObjectId;
	}

	public Long getMetricId() {
		return metricId;
	}

	public void setMetricId(Long metricId) {
		this.metricId = metricId;
	}

	public String getOverrideName() {
		return overrideName;
	}

	public void setOverrideName(String overrideName) {
		this.overrideName = overrideName;
	}
	
}
