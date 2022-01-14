package ar.com.dcc.pochibernate;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class QueryUtility {
	
	//usando HQL
	public static void listAllUsersWithBTypeOperations(SessionFactory sessionFactory) {
		System.out.print("Lista de usuarios que pertenecen a grupos con permisos de operaciones tipo B: ");
		try(Session session = sessionFactory.openSession()){	
			String hql = "SELECT DISTINCT u.login FROM User u "
					+ "JOIN GroupAssignment ga ON ga.userId = u.userId "
					+ "JOIN Group g ON g.groupId = ga.groupId "
					+ "JOIN Permission p ON p.groupId = g.groupId "
					+ "JOIN Operation o ON o.operationId = p.operationId WHERE o.type = 'B'";
			Query<String> query = (Query<String>) session.createQuery(hql);
			System.out.println(query.list());
		}
	}
	
	public static void selectUserIdEqualsOne(SessionFactory sessionFactory) {
		System.out.println("Usuario con Id 1: ");

		try(Session session = sessionFactory.openSession()){	
			String hql = "SELECT u.login FROM User u WHERE u.userId = 1";
			Query<String> query = session.createQuery(hql);
			System.out.print(query.list());
		}
	}
	
	public static void selectGroupWithIdEquals1(SessionFactory sessionFactory) {
		System.out.println("Grupo con Id 1: ");

		try(Session session = sessionFactory.openSession()){	
			String hql = "SELECT g.name FROM Group g WHERE g.groupId = 1";
			Query<String> query = session.createQuery(hql);
			System.out.print(query.list());
		}
	}
	
	public static void selectNovice(SessionFactory sessionFactory) {
		System.out.print("Users que pertenecen al grupo Novice: ");
		try(Session session = sessionFactory.openSession()){	
			String hql = "SELECT u.login FROM User u "
					+ "JOIN GroupAssignment ga ON ga.userId = u.userId "
					+ "JOIN Group g ON ga.groupId = g.groupId "
					+ "WHERE g.name = 'Novice'";
			Query<String> query = session.createQuery(hql);
			System.out.println(query.list());
		}
	}
	
	//usando criteria API
	public static void selectUserIdEqualsTwo(SessionFactory sessionFactory) {
		System.out.print("User con ID igual a 2: ");
		try(Session session = sessionFactory.openSession()){
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("userId"), 2));
			
			TypedQuery<User> query = session.createQuery(cq);
			System.out.println(query.getSingleResult().getLogin());		
		}
	}
	
	public static void listAllUsersWithBTypeOperationsCriteriaAPI(SessionFactory sessionFactory) {
		System.out.print("Lista de usuarios que pertenecen a grupos con permisos de operaciones tipo B: ");
		try(Session session = sessionFactory.openSession()){
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
											  
			
			TypedQuery<User> query = session.createQuery(cq);
			List<User> result = query.getResultList();
			for(User u : result) {
				System.out.println(u.getLogin());
			}			
		}
	}

}
