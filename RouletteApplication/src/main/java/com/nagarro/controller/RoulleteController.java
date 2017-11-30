package com.nagarro.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.model.BetAmount;
import com.nagarro.service.IRouletteGameService;
import com.nagarro.service.IRouletteService;

@Controller
@SessionAttributes("userId")
public class RoulleteController {

	@Autowired
	private IRouletteService rouletteService;
	
	@Autowired
	private IRouletteGameService rouletteGameService;

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("button", "Start Playing");
		model.put("navHeading", "Roulette");
		return "index";
	}

//	@RequestMapping("/error")
//	public String error(Map<String, Object> model) {
//		model.put("pageNotFound", "Oops sorry Page not found!!");
//		model.put("404", "404 page not found");
//		return "404";
//	}
	
	@PostMapping("/dashboard")
	public String play(Map<String, Object> model, HttpSession session, @RequestParam String userId)
			throws UnirestException, JSONException {

		JSONObject response = rouletteService.validateUser(userId);

		if (!response.toString().equals("{}")) {
			String customerName = response.getString("name");
			Double customerBalance = response.getDouble("accountBalance");
			model.put("Name", customerName);
			model.put("Balance", customerBalance);
            session.setAttribute("currentUserName",customerName);
            session.setAttribute("currentUserBalance",customerBalance);
			return "playgame";
		}
		
		model.put("errorMessage", "*Incorrect Id...please try again");
		model.put("button", "Start Playing");
		model.put("navHeading", "Roulette");
		return "index";

	}

	@PostMapping("/dashboard/betamount")
	public String test(HttpSession session, @Valid @ModelAttribute("BetAmount") BetAmount obj, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("error");
		}

		int check= rouletteGameService.playGame(session, obj);
		if(check!=0) System.out.println("bet won ");
		else System.out.println("bet lost false");
		model.addAttribute("firstamount", obj.getFirst12());
		return "betamount";
	}

}
