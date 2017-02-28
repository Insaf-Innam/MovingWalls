package com.movingwalls.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.movingwalls.entity.Approvalstatus;
import com.movingwalls.entity.Finance;
import com.movingwalls.entity.Tours;
import com.movingwalls.entity.User;

import com.movingwalls.service.MovingWallsService;

@Controller
public class MovingWallsController {

	@Autowired
	private MovingWallsService movingWallsService;

	@Autowired
	private Tours toursbean;

	@Autowired
	private User loginBean;

	@Autowired
	private Finance financeBean;

	@RequestMapping("create")
	public ModelAndView createEmployee(HttpServletRequest req) {
		List<User> userType = movingWallsService.getAllManagers();

		ModelAndView md = new ModelAndView("toursForm");
		md.addObject("managerList", userType);
		return md;
	}

	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/sendToFinance", method = RequestMethod.POST)
	public ModelAndView sendToFinance(@RequestParam Map<String, String> map, HttpServletRequest req) {

		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		String tourId = map.get("tourId");
		String approvalstatus = map.get("approvalstatus");
		String managerUserName = map.get("managerUserName");

		Tours tour = movingWallsService.getTourObject(Integer.parseInt(tourId));
		Approvalstatus approvalStatus = movingWallsService.getStatusObject(approvalstatus);

		List<Finance> financeList = movingWallsService.getAllFinance();

		int i = 0;
		if (financeList != null) {
			for (Finance financeObject : financeList) {

				if (financeObject.getTours().getId() == Integer.parseInt(tourId)) {
					++i;
				} else {

				}
			}

			if (i == 0) {
				financeBean.setApprovalstatus(approvalStatus);
				financeBean.setFmanagerUserName(managerUserName);
				financeBean.setTours(tour);
				movingWallsService.saveFinance(financeBean);
				Tours tours = movingWallsService.getTourObject(Integer.parseInt(tourId));
				tours.setFinanceApproval("submitted");
				movingWallsService.updateTour(tours);
			}
		}
		ModelAndView md = new ModelAndView("home");

		List<Tours> toursList = null;

		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);
		}

		List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
		md.addObject("getAllFinanceManagers", getAllFinanceManagers);

		List<User> allManagers = movingWallsService.getAllManagers();
		md.addObject("managerList", allManagers);

		md.addObject("toursList", toursList);
		md.addObject("userType", user.getUsertype().getId());
		req.getSession().setAttribute("userDetails", user);
		return md;
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public ModelAndView loginForm(@RequestParam Map<String, String> map, HttpServletRequest req) {

		loginBean.setUserName(map.get("username"));
		loginBean.setPassword(map.get("password"));
		User user = movingWallsService.login(loginBean);

		if (user == null)
			return new ModelAndView("login");

		ModelAndView md = new ModelAndView("home");
		ModelAndView md2 = new ModelAndView("admin");

		req.getSession().setAttribute("userDetails", user);

		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			List<Tours> toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);

			return md;
		} else {
			List<Finance> financeList = movingWallsService.getFinanceLiist(user.getUserName());
			md2.addObject("financeList", financeList);
			return md2;
		}
	}

	@RequestMapping("viewAll")
	public ModelAndView viewAll(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		List<Tours> toursList = null;
		ModelAndView md = new ModelAndView("home");

		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);

		}

		List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
		md.addObject("getAllFinanceManagers", getAllFinanceManagers);
		md.addObject("toursList", toursList);
		List<User> allManagers = movingWallsService.getAllManagers();
		md.addObject("managerList", allManagers);
		md.addObject("userType", user.getUsertype().getId());
		return md;
	}

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public ModelAndView changeStatus(@RequestParam("tourId") int tourId,
			@RequestParam("approvalstatus") int approvalstatus, HttpServletRequest req) {

		Tours tours = movingWallsService.getTourObject(tourId);
		tours.getApprovalstatus().setId(approvalstatus);

		movingWallsService.updateTour(tours);

		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		ModelAndView md = new ModelAndView("home");
		List<Tours> toursList = null;

		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);

		}

		List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
		md.addObject("getAllFinanceManagers", getAllFinanceManagers);
		md.addObject("toursList", toursList);

		List<User> allManagers = movingWallsService.getAllManagers();
		md.addObject("managerList", allManagers);

		md.addObject("userType", user.getUsertype().getId());
		return md;
	}

	@RequestMapping(value = "/financeStatus", method = RequestMethod.POST)
	public ModelAndView financeStatus(@RequestParam("tourId") int tourId,
			@RequestParam("approvalstatus") int approvalstatus, HttpServletRequest req) {

		Tours tour = movingWallsService.getTourObject(tourId);
		String approval = "";
		if (approvalstatus == 2) {
			approval = "submit";

		} else if (approvalstatus == 3) {
			approval = "approved";

		} else if (approvalstatus == 4) {
			approval = "rejected";

		} else {
			approval = "more information";

		}
		tour.setFinanceApproval(approval);
		movingWallsService.updateTour(tour);

		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		ModelAndView md2 = new ModelAndView("admin");
		List<Finance> financeList = movingWallsService.getFinanceLiist(user.getUserName());
		md2.addObject("financeList", financeList);
		return md2;
	}

	@RequestMapping(value = "/checking", method = RequestMethod.POST)
	public ModelAndView changeStatus(@RequestParam Map<String, String> map, HttpServletRequest req) {
		String tourId = map.get("tourId");
		String description = map.get("description");
		String startDate = map.get("startDate");
		String endDate = map.get("endDate");
		String mode = map.get("mode");
		String ticketCost = map.get("ticketCost");
		String homeCityCabCost = map.get("homeCityCabCost");
		String destinationCityCabCost = map.get("destinationCityCabCost");
		String hotelCost = map.get("hotelCost");
		String managerUserName = map.get("managerUserName");
		String financeApproval = map.get("financeApproval");
		System.out.println("here your value comes " + financeApproval);
		Tours tours = movingWallsService.getTourObject(Integer.parseInt(tourId));

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null;
		Date edate = null;

		try {
			sdate = format.parse(startDate);
			edate = format.parse(endDate);
		} catch (Exception e) {
			System.out.println(e);
		}

		tours.setDescription(description);
		tours.setStartDate(sdate);
		tours.setEndDate(edate);
		tours.setMode(mode);
		tours.setTicketCost(Double.parseDouble(ticketCost));
		tours.setHomeCityCabCost(Double.parseDouble(homeCityCabCost));
		tours.setDestinationCityCabCost(Double.parseDouble(destinationCityCabCost));
		tours.setHotelCost(Double.parseDouble(hotelCost));
		tours.setManagerUserName(managerUserName);
		tours.setFinanceApproval(financeApproval);

		movingWallsService.updateTour(tours);

		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");
		ModelAndView md = new ModelAndView("home");
		List<Tours> toursList = null;
		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);

		}

		List<User> allManagers = movingWallsService.getAllManagers();
		md.addObject("managerList", allManagers);

		List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
		md.addObject("getAllFinanceManagers", getAllFinanceManagers);
		md.addObject("toursList", toursList);

		md.addObject("userType", user.getUsertype().getId());
		return md;
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		ModelAndView md = new ModelAndView("login");

		req.getSession().removeAttribute("userDetails");
		req.getSession().invalidate();
		return md;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView m3(@RequestParam Map<String, String> map, HttpServletRequest req) {

		User user = (User) req.getSession().getAttribute("userDetails");
		if (user == null)
			return new ModelAndView("login");

		String des = map.get("description");
		String sdateString = map.get("startDate");
		String edateString = map.get("endDate");
		String mode = map.get("mode");
		String ticketcost = map.get("ticketCost");
		String homecitycost = map.get("homeCityCabCost");
		String destinationcitycost = map.get("destinationCityCabCost");
		String hotelcost = map.get("hotelCost");
		String managerUserName = map.get("managerUserName");
		String finance = map.get("financeApproval");
		System.out.println("here manager user name is " + managerUserName);
		String status = map.get("status");

		User UserObject = (User) req.getSession().getAttribute("userDetails");
		if (UserObject == null)

			return new ModelAndView("login");
		String userName = map.get(UserObject.getUserName());

		// User UserObject = movingWallsService.getUserObject(userName);
		Approvalstatus statusObject = movingWallsService.getStatusObject(status);

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null;
		Date edate = null;

		try {
			sdate = format.parse(sdateString);
			edate = format.parse(edateString);
			System.out.println(sdate + " here your start date");
			System.out.println(edate + " here your end date is");
		} catch (Exception e) {
			System.out.println(e);
		}

		toursbean.setDescription(des);
		toursbean.setStartDate(sdate);
		toursbean.setEndDate(edate);
		toursbean.setMode(mode);
		toursbean.setTicketCost(Double.parseDouble(ticketcost));
		toursbean.setHomeCityCabCost(Double.parseDouble(homecitycost));
		toursbean.setDestinationCityCabCost(Double.parseDouble(destinationcitycost));
		toursbean.setHotelCost(Double.parseDouble(hotelcost));
		toursbean.setManagerUserName(managerUserName);
		toursbean.setFinanceApproval(finance);
		toursbean.setUser(UserObject);
		toursbean.setApprovalstatus(statusObject);
		movingWallsService.createTours(toursbean);
		ModelAndView md = new ModelAndView("home");
		List<Tours> toursList = null;

		if (user.getUsertype().getId() == 2 || user.getUsertype().getId() == 3) {
			toursList = null;

			if (user.getUsertype().getId() == 2) {
				toursList = movingWallsService.getTourLiist(user.getId());
			} else {
				toursList = movingWallsService.getTourObjects(user.getUserName());
			}

			md.addObject("toursList", toursList);
			List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
			md.addObject("getAllFinanceManagers", getAllFinanceManagers);

			md.addObject("userType", user.getUsertype().getId());

			List<User> allManagers = movingWallsService.getAllManagers();
			md.addObject("managerList", allManagers);

		}

		List<User> getAllFinanceManagers = movingWallsService.getAllFinanceManagers();
		md.addObject("getAllFinanceManagers", getAllFinanceManagers);
		md.addObject("toursList", toursList);

		List<User> allManagers = movingWallsService.getAllManagers();
		md.addObject("managerList", allManagers);

		md.addObject("userType", UserObject.getUsertype().getId());
		return md;

	}
}
