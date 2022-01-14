package ar.com.dcc.pochibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	private static SessionFactory factory;
	private static final boolean MOCK_FAIL = false;

	public static void main(String[] args) {
		  try {
	          factory = new Configuration().configure().buildSessionFactory();
	       } catch (Throwable ex) { 
	          throw new ExceptionInInitializerError(ex); 
	       }
		  System.out.println("Configuration Success");
		  DataUtility.FillTables(factory, MOCK_FAIL);
		  System.out.println("Data Definition Success");
		  System.out.println("HQL queries--------------------------");
		  QueryUtility.listAllUsersWithBTypeOperations(factory);
		  QueryUtility.selectNovice(factory);
		  System.out.println("Criteria API queries-----------------");
		  QueryUtility.selectUserIdEqualsTwo(factory);
		  QueryUtility.listAllUsersWithBTypeOperationsCriteriaAPI(factory);
		  System.out.println("Data Manipulation Success");

	}
}
