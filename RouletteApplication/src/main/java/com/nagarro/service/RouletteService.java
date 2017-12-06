package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

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

	public int generateRandomNumber() {
		ArrayList<Long> randomNumbers = new ArrayList<Long>();
		int randomNumber = ThreadLocalRandom.current().nextInt(1, 11);

		// generating 20 random number of length equals to above generated
		// random number
		for (int i = 0; i < 20; i++) {
			long randomNew = ThreadLocalRandom.current().nextLong((long) Math.pow(10, randomNumber - 1),
					(long) Math.pow(10, randomNumber));
			randomNumbers.add(randomNew);
		}

		Collections.sort(randomNumbers);
		long firstListSum = 0, secondListSum = 0;
		int i = 0, firstListIndex = 0, secondListIndex = 0;

		/*
		 * for (i = 0; i < randomNumbers.size(); i += 2) { if (flag == 1) {
		 * firstListSum += randomNumbers.get(i); secondListSum +=
		 * randomNumbers.get(i + 1); flag--; } else { secondListSum +=
		 * randomNumbers.get(i); firstListSum += randomNumbers.get(i + 1);
		 * flag++; } }
		 */

		for (i = randomNumbers.size() - 1; i > 0; i--) {
			if (firstListIndex < 10 && secondListIndex < 10) {

				if (firstListSum >= secondListSum) {
					firstListSum += randomNumbers.get(i - 1);
					secondListSum += randomNumbers.get(i);
					firstListIndex++;
					secondListIndex++;
				} else {
					firstListSum += randomNumbers.get(i);
					secondListSum += randomNumbers.get(i - 1);
					firstListIndex++;
					secondListIndex++;
				}
			} else if (secondListIndex >= 10) {
				firstListSum += randomNumbers.get(i);
				firstListIndex++;
			} else {
				secondListSum += randomNumbers.get(i);
				secondListIndex++;
			}
		}
		return (int) ((Math.abs(firstListSum - secondListSum)) % 37);
	}

	public int gameResult(BetAmount bet, HttpSession session) {
		int result = 0;
		int randomNum = generateRandomNumber();
		session.setAttribute("randomNumber", randomNum);
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
		if (randomNum % 2 == 0 && randomNum != 0)
			result += bet.getEven() * 1.25;
		if (randomNum % 2 == 1)
			result += bet.getOdd() * 1.25;

		return result;
	}

}
