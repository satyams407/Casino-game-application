package com.nagarro.service;

import javax.servlet.http.HttpSession;

import com.nagarro.model.BetAmount;

public interface IRouletteGameService {


	public int playGame(HttpSession session, BetAmount obj);

}
