package com.example.data.sample.repo;

import com.example.data.sample.entities.MetricFilter;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.ANSI)
@Repository(value = "oltpDataSource")
public interface MetricFilterRepository extends CrudRepository<MetricFilter, Long> {

}
