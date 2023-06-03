package com.user;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernateutil {
	private static final SessionFactory sessionFactory ;
	static {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			
		}catch(Throwable th) {
			throw new ExceptionInInitializerError(th);
		}
	}
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
	
}
