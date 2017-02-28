package com.movingwalls.service;

import java.util.List;

import com.movingwalls.entity.Approvalstatus;
import com.movingwalls.entity.Finance;
import com.movingwalls.entity.Tours;
import com.movingwalls.entity.User;

public interface MovingWallsService {

	public void createTours(Tours tours);

	public User getUserObject(String name);
	
	public List<Tours> getTourObjects(String name);

	public Approvalstatus getStatusObject(String name);

	public User login(User user);

	public List<Tours> getTourLiist(int id);

	public Tours getTourObject(int id);

	public void updateTour(Tours tour);

	public List<User> getAllManagers();

	public List<User> getAllFinanceManagers();

	public void saveFinance(Finance finance);

	public List<Finance> getAllFinance();

	public List<Finance> getFinanceLiist(String name);

	public Finance getFinanceObject(int id);

	public void updatefinance(Finance finance);

}
