package com.example.data.sample.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.example.BaseDataSampleTest;
import com.example.data.sample.entities.CustomMetric;
import com.example.data.sample.repo.CustomMetricRepository;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class CustomMetricControllerTest extends BaseDataSampleTest {

	@Inject
	@Client("/v2/metrics")
	private RxHttpClient client;

	@Inject
	private CustomMetricRepository customMetricRepository;

	@Test
	public void indexResponseTest() {
		HttpResponse<String> response = client.toBlocking().exchange("/", String.class);
		assertEquals("hello from custom metrics", response.body());
	}

	@Test
	public void getMetricsForClientTest() {
		String clientObjectId = CLIENT_ID;

		when(customMetricRepository.findByClientObjectId(clientObjectId)).then(Invocation -> {
			List<CustomMetric> results = new ArrayList<>();

			return results;
		});

		HttpResponse<List<CustomMetric>> response = client.toBlocking().exchange(HttpRequest.GET("/" + clientObjectId),
				Argument.listOf(CustomMetric.class));

		List<CustomMetric> results = response.getBody().orElseGet(null);
		assertEquals(0, results.size());
	}

	@MockBean(bean = CustomMetricRepository.class)
	CustomMetricRepository getMockCustomMetricRepository() {
		return mock(CustomMetricRepository.class);
	}

}
