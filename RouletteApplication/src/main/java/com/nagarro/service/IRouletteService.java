package com.nagarro.service;

import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.model.BetAmount;

public interface IRouletteService {

	public JSONObject validateUser(String UserId) throws UnirestException, JSONException;
	
	public int getBlockedAmount(BetAmount betAmount);
	
	public int gameResult(BetAmount bet); 
	
	public int getRandomNumber();
}
