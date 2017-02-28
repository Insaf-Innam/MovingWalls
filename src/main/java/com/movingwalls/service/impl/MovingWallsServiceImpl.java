package com.movingwalls.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movingwalls.dao.MovingWallsDAO;
import com.movingwalls.entity.Approvalstatus;
import com.movingwalls.entity.Finance;
import com.movingwalls.entity.Tours;
import com.movingwalls.entity.User;
import com.movingwalls.service.MovingWallsService;

@Service
@Transactional
public class MovingWallsServiceImpl implements MovingWallsService {

	@Autowired
	private MovingWallsDAO movingWallsDAO;

	@Override
	public void createTours(Tours tours) {

		movingWallsDAO.createTours(tours);

	}

	@Override
	public User getUserObject(String name) {

		return movingWallsDAO.getUserObject(name);
	}

	@Override
	public Approvalstatus getStatusObject(String name) {

		return movingWallsDAO.getStatusObject(name);
	}

	@Override
	public User login(User user) {

		return movingWallsDAO.login(user);
	}

	@Override
	public List<Tours> getTourLiist(int id) {

		return movingWallsDAO.getTourLiist(id);
	}

	@Override
	public Tours getTourObject(int id) {

		return movingWallsDAO.getTourObject(id);
	}

	@Override
	public void updateTour(Tours tour) {

		movingWallsDAO.updateTour(tour);
	}

	@Override
	public List<User> getAllManagers() {

		return movingWallsDAO.getAllManagers();
	}

	@Override
	public List<User> getAllFinanceManagers() {

		return movingWallsDAO.getAllFinanceManagers();
	}

	@Override
	public void saveFinance(Finance finance) {

		movingWallsDAO.saveFinance(finance);

	}

	@Override
	public List<Finance> getAllFinance() {

		return movingWallsDAO.getAllFinance();
	}

	@Override
	public List<Finance> getFinanceLiist(String name) {

		return movingWallsDAO.getFinanceLiist(name);

	}

	@Override
	public Finance getFinanceObject(int id) {

		return movingWallsDAO.getFinanceObject(id);
	}

	@Override
	public void updatefinance(Finance finance) {

		movingWallsDAO.updatefinance(finance);

	}

	@Override
	public List<Tours> getTourObjects(String name) {

		return movingWallsDAO.getTourObjects(name);
	}

}
