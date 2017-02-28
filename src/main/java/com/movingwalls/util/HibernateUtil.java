package com.movingwalls.util;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movingwalls.entity.Approvalstatus;
import com.movingwalls.entity.Finance;
import com.movingwalls.entity.Tours;
import com.movingwalls.entity.User;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;

	public void createTours(Tours tours) {
		sessionFactory.getCurrentSession().save(tours);
	}

	public User getUserObject(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("name", name));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	public Approvalstatus getStatusObject(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Approvalstatus.class)
				.add(Restrictions.eq("statusType", name));
		Approvalstatus appStatus = (Approvalstatus) criteria.uniqueResult();
		return appStatus;
	}

	public User login(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions
				.and(Restrictions.eq("userName", user.getUserName()), Restrictions.eq("password", user.getPassword())));
		User userLogin = (User) criteria.uniqueResult();
		return userLogin;
	}

	public Tours getTourObject(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tours.class)
				.add(Restrictions.eq("id", id));
		Tours tour = (Tours) criteria.uniqueResult();
		return tour;
	}

	public void updateTour(Tours tour) {
		sessionFactory.getCurrentSession().update(tour);
	}

	public List<Tours> getTourLiist(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tours.class)
				.add(Restrictions.eq("user.id", id));
		List<Tours> toursList = criteria.list();
		return toursList;
	}

	public List<User> getAllManagers() {
		int value = 3;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("usertype.id", value));
		System.out.println("okjbhs sabcas cjbadc kasbjkbkjvb knjk jkbnkj jkhnkj lknh");
		List<User> userList = criteria.list();
		return userList;
	}

	public void updateStatusAgain(final Tours tours) {
		sessionFactory.getCurrentSession().update(tours);
	}

	public List<Finance> getFinanceLiist(String name) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Finance.class)
				.add(Restrictions.eq("fmanagerUserName", name));
		List<Finance> financeLists = criteria.list();
		return financeLists;
	}

	public List<User> getAllFinanceManagers() {
		int value = 4;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("usertype.id", value));
		List<User> userList = criteria.list();
		return userList;
	}

	public void saveFinance(Finance finance) {
		sessionFactory.getCurrentSession().save(finance);
	}

	public List<Finance> getAllFinance() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Finance.class);
		List<Finance> financeList = (List<Finance>) criteria.list();
		return financeList;
	}

	public void updatefinance(Finance finance) {

		sessionFactory.getCurrentSession().update(finance);

	}

	public Finance getFinanceObject(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Finance.class)
				.add(Restrictions.eq("tours.id", id));
		Finance financeObject = (Finance) criteria.uniqueResult();
		return financeObject;
	}

	public List<Tours> getTourObjects(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tours.class)
				.add(Restrictions.eq("managerUserName", name));
		List<Tours> managerTourList = (List<Tours>) criteria.list();
		return managerTourList;
	}
}
