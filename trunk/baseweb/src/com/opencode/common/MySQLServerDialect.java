package com.opencode.common;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

public class MySQLServerDialect extends SQLServerDialect  {
	
	public MySQLServerDialect() {
        super();
        registerHibernateType(Types.DECIMAL, Hibernate.DOUBLE.getName());
    }


}
