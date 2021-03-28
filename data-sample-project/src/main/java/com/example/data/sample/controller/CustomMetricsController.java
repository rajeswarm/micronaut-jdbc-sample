package com.example.data.sample.controller;

import java.util.List;

import javax.inject.Inject;

import com.example.data.sample.entities.CustomMetric;
import com.example.data.sample.entities.UserMetricAssociation;
import com.example.data.sample.framework.RequestContext;
import com.example.data.sample.responses.MetricChangeResponse;
import com.example.data.sample.services.CustomMetricService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

@Controller(value = "/v2/metrics")
public class CustomMetricsController {

	@Inject
	private CustomMetricService customMetricService;

	@Inject
	private RequestContext requestContext;

	@Get("/")
	public Single<HttpResponse<String>> index() {
		return Single.just(HttpResponse.ok("hello from custom metrics"));
	}

	@Get("/{clientObjectId}")
	public Single<HttpResponse<List<CustomMetric>>> getMetricsForClient(@PathVariable String clientObjectId) {
		requestContext.init(clientObjectId);

		List<CustomMetric> metrics = customMetricService.getCustomMetricsForClient(clientObjectId);
		return Single.just(HttpResponse.ok(metrics));
	}

	@Post
	public Single<HttpResponse<MetricChangeResponse>> createMetric(CustomMetric metric) {
		requestContext.init(metric.getClientObjectId());

		customMetricService.createCustomMetric(metric);
		return Single.just(HttpResponse.ok(new MetricChangeResponse("metric created")));
	}

	@Get("/{clientObjectId}/{userAOId}")
	public Single<HttpResponse<List<UserMetricAssociation>>> getMetricsForUser(@PathVariable String clientObjectId,
			@PathVariable String userAOId) {
		requestContext.init(clientObjectId);

		List<UserMetricAssociation> metrics = customMetricService.getCustomMetricForClientAndUser(clientObjectId,
				userAOId);
		return Single.just(HttpResponse.ok(metrics));
	}
	
	@Post("/association")
	public Single<HttpResponse<MetricChangeResponse>> createUserMetricAssociation(UserMetricAssociation userMetricAssociation) {
		requestContext.init(userMetricAssociation.getMetric().getClientObjectId());

		customMetricService.createUserMetricAssoication(userMetricAssociation);
		return Single.just(HttpResponse.ok(new MetricChangeResponse("metric association created")));
	}
}
