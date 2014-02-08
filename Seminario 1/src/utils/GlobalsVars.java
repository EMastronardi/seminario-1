package utils;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import persistencia.HibernateUtil;

public class GlobalsVars {
	public static Session HIBERATE_SESSION = HibernateUtil.getCurrent();
}
