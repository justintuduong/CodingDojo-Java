package com.codingdojo.ninjagold.ninjagold;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.*;

@Controller
@RequestMapping

public class NinjaGoldController {
	
//	------------------------------------------------------------------------
//	Initiate session, render game
//	------------------------------------------------------------------------
	
	@RequestMapping("/") // if session = null, invoke session
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == (null)) {
			session.setAttribute("gold", 0); // gold
			session.setAttribute("activityLog", new ArrayList<String>() ); // activity log
			System.out.println("Initiating session.");
		}
		session.getAttribute("gold"); // getter to update total gold
		return "index.jsp";
	}
	
	
//	------------------------------------------------------------------------
//	Handles POST method, game logic and redirect. (activity log in progress)
//	------------------------------------------------------------------------
//	activity log will also require timestamps.
	
	
	@RequestMapping("/process")
	public String farm(@RequestParam(value="action") String action, HttpSession session) {
		if (action.equals ("farm")) {
			int gold = (int) session.getAttribute("gold");
			int goldFromFarm = ThreadLocalRandom.current().nextInt(10,21);
			System.out.println("You have just farmed " +goldFromFarm + " gold.");
			session.setAttribute("gold", gold+goldFromFarm);
			System.out.println("Your total gold is " + session.getAttribute("gold"));
			
//			ArrayList<String> activityLog = ArrayList<String>;
//			activityLog.add(0, "You've earned "+goldFromFarm+" gold.");
		}
		if (action.equals("house")) {
			int gold = (int) session.getAttribute("gold");
			int goldFromHouse = ThreadLocalRandom.current().nextInt(2,6);
			session.setAttribute("gold", gold + goldFromHouse);
			
//			ArrayList<String> activityLog = ArrayList<String>;
//			activityLog.add(0, "You've earned "+goldFromHouse+" gold.");
		}
		if (action.equals("cave")) {
			int gold = (int) session.getAttribute("gold");
			int goldFromCave = ThreadLocalRandom.current().nextInt(5,11);
			session.setAttribute("gold", gold + goldFromCave);
			
//			ArrayList<String> activityLog = ArrayList<String>;
//			activityLog.add(0, "You've earned "+goldFromCave+" gold.");
		}
		if (action.equals("casino")) {
			int gold = (int) session.getAttribute("gold");
			int goldFromCasino = ThreadLocalRandom.current().nextInt(-50,51);
			session.setAttribute("gold", gold + goldFromCasino);
			
//			ArrayList<String> activityLog = ArrayList<String>;
//			activityLog.add(0, "You've earned "+goldFromCasino+" gold.");
		}
		return "redirect:/";
	}
	
}


