package com.sripal.Generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomSsnId implements IdentifierGenerator{
	private final String sql="select ssnidno_seq.nextval from dual";
	private final String prefix="SId";
	 String suffix="";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
	
	 try {
		 Connection connection = session.connection();
		 Statement statement = connection.createStatement();
		 ResultSet resultSet = statement.executeQuery(sql);
		 
		 if (resultSet.next()) {
			
			 int seq1 = resultSet.getInt(1);
			 suffix= String.valueOf(seq1);
		}
		
	} catch (Exception e) {
	e.printStackTrace();
	}
	 
	 
		
		return prefix+suffix;
	}

}
