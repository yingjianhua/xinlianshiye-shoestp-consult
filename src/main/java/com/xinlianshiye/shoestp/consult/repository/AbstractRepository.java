package com.xinlianshiye.shoestp.consult.repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.MySQLTemplates;

public abstract class AbstractRepository {
	
	@Autowired
	protected EntityManager em;
	
	protected JPAQueryFactory queryFactory;
	
	@Autowired
	protected DataSource dataSource;
	
	@PostConstruct
	public void init() {
		queryFactory = new JPAQueryFactory(em);
	}
	
	protected JPASQLQuery<?> createSqlQuery() {
		return new JPASQLQuery<>(em, new MySQLTemplates());
	}
	
}
