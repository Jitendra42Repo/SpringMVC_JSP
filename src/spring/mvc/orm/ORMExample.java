package spring.mvc.orm;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.bean.User;

@Repository
@Transactional
public class ORMExample {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public List<User> findAllUsers() {
		System.out.println("Inside the findAllUsers method of ORMExample repository.");
		String qlString = "from User order by iduser";
		TypedQuery<User> typedQuery = entityManager.createQuery(qlString, User.class);
		return typedQuery.getResultList();
	}

	public boolean ormUpdateUsr(int iduser, boolean enabled) {
		boolean status = false;
		System.out.println("Inside the ormUpdateUsr method of ORMExample repository.");
		String hsl = "update user set enabled=? where iduser=?"; 
		Query query = entityManager.createNativeQuery(hsl);
		query.setParameter(1, enabled);
		query.setParameter(2, iduser);
		System.out.println("Testing the query");
		int affectedRow = query.executeUpdate();
		if (affectedRow > 0) {
			status = true;
		}
		return status;
	}
	
}
