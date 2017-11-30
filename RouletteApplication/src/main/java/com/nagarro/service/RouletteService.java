package com.nagarro.service;

import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nagarro.model.BetAmount;

@Service("IRouletteService")
public class RouletteService implements IRouletteService {

	public JSONObject validateUser(String userId) throws UnirestException, JSONException {
		final HttpResponse<JsonNode> getResponse = Unirest.get("http://localhost:8080/user/{userId}")
				.routeParam("userId", userId).asJson();

		return getResponse.getBody().getObject();
	}

	// nextInt is normally exclusive of the top value,
	// so add 1 to make it inclusive
	public int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(0, 37);
	}

	public int getBlockedAmount(BetAmount betAmount) {
		int sum = 0;
		sum += betAmount.getFirst12();
		sum += betAmount.getSecond12();
		sum += betAmount.getThird12();
		sum += betAmount.getOneToEighteen();
		sum += betAmount.getNineteenToThirySix();
		sum += betAmount.getEven();
		sum += betAmount.getOdd();
		sum += betAmount.getZero();
		return sum;
	}

	public int gameResult(BetAmount bet) {
		int result = 0;
		int randomNum = getRandomNumber();
		if (1 <= randomNum && randomNum <= 12)
			result += bet.getFirst12() * 1.5;
		if (13 <= randomNum && randomNum <= 24)
			result += bet.getSecond12() * 1.5;
		if (25 <= randomNum && randomNum <= 36)
			result += bet.getThird12() * 1.5;
		if (randomNum == 0)
			result += bet.getZero() * 10;
		if (1 <= randomNum && randomNum <= 18)
			result += bet.getOneToEighteen() * 1.25;
		if (19 <= randomNum && randomNum <= 36)
			result += bet.getNineteenToThirySix() * 1.25;
		if (randomNum % 2 == 0)
			result += bet.getEven() * 1.25;
		if (randomNum % 2 == 1)
			result += bet.getOdd() * 1.25;
		return result;
	}

}
