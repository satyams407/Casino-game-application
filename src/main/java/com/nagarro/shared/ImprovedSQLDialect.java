package com.nagarro.shared;

import org.hibernate.dialect.MySQL5Dialect;

public class ImprovedSQLDialect extends MySQL5Dialect {
	 @Override
	    public String getDropSequenceString(String sequenceName) {
	        // Adding the "if exists" clause to avoid warnings
	        return "drop sequence if exists " + sequenceName;
	    }

	    @Override
	    public boolean dropConstraints() {
	        // We don't need to drop constraints before dropping tables, that just leads to error
	        // messages about missing tables when we don't have a schema in the database
	        return false;
	    }

}
