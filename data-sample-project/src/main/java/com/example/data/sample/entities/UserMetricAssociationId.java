package com.example.data.sample.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserMetricAssociationId {

	@Column(name = "kpi_obj_ky")
	private Long metricId;

	@Column(name = "usr_ao_id")
	private String userAOId;

	public Long getMetricId() {
		return metricId;
	}

	public void setMetricId(Long metricId) {
		this.metricId = metricId;
	}

	public String getUserAOId() {
		return userAOId;
	}

	public void setUserAOId(String userAOId) {
		this.userAOId = userAOId;
	}
	
	
}
