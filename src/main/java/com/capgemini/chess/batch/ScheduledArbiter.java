package com.capgemini.chess.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.chess.exception.GameNotFoundException;
import com.capgemini.chess.service.AbandonedGamesArbiterService;

/**
 * @author JBLAZKOW
 *
 */
@Component 
public class ScheduledArbiter {
	public static final int CHECKING_TIME = 10000;
	@Autowired
	private AbandonedGamesArbiterService arbiterService;
	/**
	 * @throws GameNotFoundException
	 */

	@Scheduled(fixedRate = CHECKING_TIME)
	public final void scheduledArbiterAbandonedGames() throws GameNotFoundException {
		arbiterService.arbiterAbandonedGames();
	}

}