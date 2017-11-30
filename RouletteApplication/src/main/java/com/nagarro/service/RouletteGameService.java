package com.nagarro.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.BetAmount;

@Service("IRouletteGameService")
public class RouletteGameService implements IRouletteGameService {

	@Autowired
	IRouletteService rouletteService;

	public boolean checkBalance(HttpSession session, BetAmount betAmount) {
		double balance = (double) session.getAttribute("currentUserBalance");
		double bet = (double) rouletteService.getBlockedAmount(betAmount);
		if (bet < balance)
			return true;
		return false;
	}

	public int playGame(HttpSession session, BetAmount betAmount){
		int result=0;
		if(checkBalance(session,betAmount)==true){
	       result= rouletteService.gameResult(betAmount);
	       System.out.println("result is "+ result);
	   }
		else{
			System.out.println("low balance ");
		}
		return result;
	}

}
