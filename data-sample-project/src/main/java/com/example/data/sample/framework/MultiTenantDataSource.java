package com.example.data.sample.framework;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import io.micronaut.context.ApplicationContext;

public class MultiTenantDataSource implements DataSource {

	private final ApplicationContext applicationContext;

	public MultiTenantDataSource(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	private DataSource getCurrentDataSource() {
		RequestContext requestContext = this.applicationContext.getBean(RequestContext.class);
		return DatasourceFactory.getCurrentDataSource(requestContext);
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return getCurrentDataSource().getParentLogger();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (iface.isInstance(this)) {
			return (T) this;
		}

		return getCurrentDataSource().unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return iface.isInstance(this) || getCurrentDataSource().isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		DataSource currentDataSource = getCurrentDataSource();
		Connection connection = currentDataSource.getConnection();
		return connection;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return getCurrentDataSource().getConnection(username, password);
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return getCurrentDataSource().getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		getCurrentDataSource().setLogWriter(out);

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		getCurrentDataSource().setLoginTimeout(seconds);

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return getCurrentDataSource().getLoginTimeout();
	}

}
