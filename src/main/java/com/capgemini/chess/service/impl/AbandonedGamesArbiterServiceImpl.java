package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.enums.Result;
import com.capgemini.chess.exception.GameNotFoundException;
import com.capgemini.chess.service.AbandonedGamesArbiterService;
import com.capgemini.chess.service.dao.GameDao;

@Service
public class AbandonedGamesArbiterServiceImpl implements AbandonedGamesArbiterService {
	public static final int MAX_TIME_FOR_MOVE_IN_MINUTES = 30;
	@Autowired
	private GameDao gameDao;

	@Override
	public final List<GameEntity> arbiterAbandonedGames() throws GameNotFoundException {
		List<GameEntity> games = getAllUnfinishedGames();
		List<GameEntity> expiredGames = new ArrayList<GameEntity>();
		for (GameEntity game : games) {
			if (isExpired(game)) {
				game = setPlayerToMoveAsALoser(game);
				expiredGames.add(game);
			}
		}
		updateGames(expiredGames);
		return expiredGames;
	}
	
	private void updateGames(final List<GameEntity> games) throws GameNotFoundException {
		for (GameEntity game : games) {
			gameDao.updateGame(game);
		}
	}

	private boolean isExpired(final GameEntity game) {
		return expirationDate(game).isBeforeNow();
	}

	private List<GameEntity> getAllUnfinishedGames() {
		return gameDao.getAllUnfinishedGames();
	}
	
	private GameEntity setPlayerToMoveAsALoser(final GameEntity game) throws GameNotFoundException {
		GameEntity foundGame = gameDao.getGameById(game.getId());
		if (foundGame.getPlayerIdTurn() == foundGame.getWhitePlayerId()) {
			foundGame.setState(Result.BLACK_WON);
		} else {
			foundGame.setState(Result.WHITE_WON);
		}
		return foundGame;
	}
	
	private DateTime expirationDate(final GameEntity game) {
		return game.getLastMoveTime().plusMinutes(MAX_TIME_FOR_MOVE_IN_MINUTES);
	}


}
