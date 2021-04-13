package com.example;

import javax.sql.DataSource;

import io.micronaut.test.annotation.MockBean;

public abstract class BaseDataSampleTest {

	protected static final String CLIENT_ID = "CLIENT_A";

	@MockBean(bean = DataSource.class, named = "oltpDataSource")
	DataSource getMockOltpDataSource(DataSource defaultDataSource) {
		return defaultDataSource;
	}
}
