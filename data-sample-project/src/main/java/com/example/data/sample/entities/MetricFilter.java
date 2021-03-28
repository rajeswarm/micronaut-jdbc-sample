package com.example.data.sample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_kpi_filter")
public class MetricFilter {

	@Id
	@Column(name = "kpi_filter_ky")
	private Long filterId;

	@Column(name = "kpi_obj_ky")
	private Long metricId;

	@Column(name = "clnt_obj_id")
	private String clientObjectId;

	@Column(name = "filter_val")
	private String filterValue;
	
	@Column(name = "kpi_obj_ky")
	@ManyToOne
	@GeneratedValue //work around so that it does not create duplicate column for kpi_obj_ky during insert
	private CustomMetric metric;

	public CustomMetric getMetric() {
		return metric;
	}

	public void setMetric(CustomMetric metric) {
		this.metric = metric;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

	public Long getMetricId() {
		return metricId;
	}

	public void setMetricId(Long metricId) {
		this.metricId = metricId;
	}

	public String getClientObjectId() {
		return clientObjectId;
	}

	public void setClientObjectId(String clientObjectId) {
		this.clientObjectId = clientObjectId;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

}
