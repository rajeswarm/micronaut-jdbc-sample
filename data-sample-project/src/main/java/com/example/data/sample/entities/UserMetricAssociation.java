package com.example.data.sample.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_usr_kpi_obj_accs")
public class UserMetricAssociation {

	@EmbeddedId
	private UserMetricAssociationId userMetricAssociationId;

	@Column(name = "clnt_obj_id")
	private String clientObjectId;

	@Column(name = "accs_type_cd")
	private String accessTypeCode;
	
	@ManyToOne
	@Column(name = "kpi_obj_ky")
	@GeneratedValue //workworund so that it does not duplicate this column in INSERT statement
	private CustomMetric metric;

	public UserMetricAssociationId getUserMetricAssociationId() {
		return userMetricAssociationId;
	}

	public void setUserMetricAssociationId(UserMetricAssociationId userMetricAssociationId) {
		this.userMetricAssociationId = userMetricAssociationId;
	}

	public String getClientObjectId() {
		return clientObjectId;
	}

	public void setClientObjectId(String clientObjectId) {
		this.clientObjectId = clientObjectId;
	}

	public String getAccessTypeCode() {
		return accessTypeCode;
	}

	public void setAccessTypeCode(String accessTypeCode) {
		this.accessTypeCode = accessTypeCode;
	}

	public CustomMetric getMetric() {
		return metric;
	}

	public void setMetric(CustomMetric metric) {
		this.metric = metric;
	}
	
	
}
