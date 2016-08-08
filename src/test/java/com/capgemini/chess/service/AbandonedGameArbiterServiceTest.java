package com.capgemini.chess.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.enums.Result;
import com.capgemini.chess.exception.GameNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AbandonedGameArbiterServiceTest {
	@Autowired
	private AbandonedGamesArbiterService arbiterService;

	@ComponentScan
	@Configuration
	static class TestContextConfiguration {

	}

	@Test
	public void shouldUpdateExpiredGamesToLastPlayerToMoveLosingGame() throws GameNotFoundException {
		List<GameEntity> changedGames = arbiterService.arbiterAbandonedGames();
		Assert.assertEquals(2, changedGames.size());
		Assert.assertNotEquals(Result.NOT_FINISHED, changedGames.get(0).getState());
		Assert.assertNotEquals(Result.NOT_FINISHED, changedGames.get(1).getState());
	}
}
