package ar.com.dcc.pochibernate;


import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DataUtility {
	
	
	public static void FillTables(SessionFactory sessionFactory, boolean failIfTrue) {
		Transaction inserts = null;
		try(Session session = sessionFactory.openSession()){			
			inserts = session.beginTransaction();
			
			Group admins = new Group("admins", "Administradores, el grupo de mayor privilegio");
			session.save(admins);
			Group novice = new Group("novice", "Novice el grupo de menores privilegios");
			session.save(novice);
			
			User agustin = new User("agustin", "dcc123", admins);
			User pedro = new User("pedro", "dcc123", novice);
			User juan = new User("juan", "pass123", novice);
			
			session.save(agustin);
			session.save(pedro);
			session.save(juan);

			
			Operation dropUser = new Operation("DROP USER", "Borra un usuario", 'B');
			session.save(dropUser);
			Operation modifyTable = new Operation("MODIFY TABLE", "Modifica una tabla", 'M');
			session.save(modifyTable);
			Operation createUser = new Operation("CREATE USER", "Crea un usuario nuevo", 'A');
			session.save(createUser);
			
			
			session.save(new Permission(admins, dropUser));			
			session.save(new Permission(admins, modifyTable));			
			session.save(new Permission(novice, modifyTable));			
			session.save(new Permission(admins, createUser));
			
			GroupAssignment ga = new GroupAssignment(novice, agustin);
			session.save(ga);
			GroupAssignment gaAdmin = new GroupAssignment(admins, agustin);
			session.save(gaAdmin);
			session.save(new GroupAssignment(novice, juan));
			session.save(new GroupAssignment(novice, pedro));
			session.save(new GroupAssignment(novice, agustin));
			session.save(new GroupAssignment(admins, agustin));
			
			
			
			if(failIfTrue) {
				throw new HibernateException("Intentional faliure");
			}
			
			inserts.commit();
		}catch(HibernateException he) {
			if (inserts!=null) {
				inserts.rollback();
			}
	         he.printStackTrace(); 
		}
	}
}
