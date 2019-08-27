package com.knowledgetracker.domain;

import java.sql.Types;

public class CustomPostgreSqlDialect extends org.hibernate.dialect.PostgreSQL95Dialect{
	public CustomPostgreSqlDialect() {
		super();
		//System.out.println("Register Hibernate Type ... ");
        registerHibernateType(Types.ARRAY, "array");

        //System.out.println("Register Column Type ... ");
        registerColumnType(Types.ARRAY, "integer[]");
    }

}
