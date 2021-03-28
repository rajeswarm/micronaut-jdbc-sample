package com.example.data.sample.framework;

import io.micronaut.runtime.http.scope.RequestScope;

@RequestScope
public class RequestContext {

	private String clientObjectId;

	public String getClientObjectId() {
		return clientObjectId;
	}

	public void init(String clientObjectId) {
		this.clientObjectId = clientObjectId;
	}
}
