package com.example.data.sample.framework;

import java.sql.Connection;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.micronaut.aop.InterceptorBean;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.transaction.SynchronousTransactionManager;

@Singleton
@InterceptorBean(TransactionalWrite.class)
public class TransactionalWriteInterceptor implements MethodInterceptor<Object, Object>{

	@Inject
	private SynchronousTransactionManager<Connection> transactionManager;
	
	@Override
	public Object intercept(MethodInvocationContext<Object, Object> context) {
		return transactionManager.executeWrite(status -> {
			return context.proceed();
		});
	}

}
