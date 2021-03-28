package com.example.data.sample.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.example.data.sample.entities.CustomMetric;
import com.example.data.sample.entities.UserMetricAssociation;
import com.example.data.sample.framework.TransactionalWrite;
import com.example.data.sample.repo.CustomMetricRepository;
import com.example.data.sample.repo.MetricFilterRepository;
import com.example.data.sample.repo.UserMetricAssociationRepository;

@Singleton
public class CustomMetricService {

	@Inject
	private CustomMetricRepository customMetricRepository;

	@Inject
	private MetricFilterRepository metricFilterRepository;

	@Inject
	private UserMetricAssociationRepository userMetricAssociationRepository;

	public List<CustomMetric> getCustomMetricsForClient(String clientObjectId) {
		return customMetricRepository.findByClientObjectId(clientObjectId);
	}

	@TransactionalWrite
	public void createCustomMetric(CustomMetric metric) {
		customMetricRepository.save(metric);

		if (metric.getFilters() != null && metric.getFilters().size() > 0) {
			metric.getFilters().forEach(f -> {
				f.setClientObjectId(metric.getClientObjectId());
				f.setMetricId(metric.getMetricId());
			});

			metricFilterRepository.saveAll(metric.getFilters());
		}
	}

	public List<UserMetricAssociation> getCustomMetricForClientAndUser(String clientObjectId, String userAOId) {
		return userMetricAssociationRepository.findByClientObjectIdAndUserMetricAssociationIdUserAOId(clientObjectId,
				userAOId);
	}

	@TransactionalWrite
	public void createUserMetricAssoication(UserMetricAssociation association) {
		if (association.getMetric() == null) {
			throw new RuntimeException("metric must not be null");
		}

		Long metricId = association.getMetric().getMetricId();
		// check if metric already exists
		boolean isExistingMetric = customMetricRepository.existsById(metricId);
		if (!isExistingMetric) {
			CustomMetric metric = association.getMetric();
			customMetricRepository.save(metric);

			if (metric.getFilters() != null && metric.getFilters().size() > 0) {
				metric.getFilters().forEach(f -> {
					f.setClientObjectId(metric.getClientObjectId());
					f.setMetricId(metric.getMetricId());
				});

				metricFilterRepository.saveAll(metric.getFilters());
			}
		}

		userMetricAssociationRepository.save(association);
	}
}
