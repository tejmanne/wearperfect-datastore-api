package com.wearperfect.datastoreapi.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearperfect.datastoreapi.models.User;
import com.wearperfect.datastoreapi.repositories.UserRepository;
import com.wearperfect.datastoreapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EntityManager em;

	@Override
	public User getUserDetails(Long userId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> queryRoot = cq.from(User.class);
		//cq.select(queryRoot).where(cb.equal(queryRoot.get("id"), userId));
		//return (User) em.createQuery(cq).getSingleResult();
		TypedQuery<User> query = em.createQuery("select * from user where id="+userId, User.class);
		return query.getSingleResult();
	}

	@Override
	public User getUserDetails(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> queryRoot = cq.from(User.class);
		ParameterExpression<String> usernameColumn = cb.parameter(String.class);
		cq.select(queryRoot).where(cb.equal(queryRoot.get("username"), usernameColumn));
		TypedQuery<User> query = em.createQuery(cq);
		query.setParameter(usernameColumn, username);
		return (User) query.getSingleResult();
	}

}
