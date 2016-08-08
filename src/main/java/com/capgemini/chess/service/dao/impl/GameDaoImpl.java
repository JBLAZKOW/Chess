package com.capgemini.chess.service.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.enums.Result;
import com.capgemini.chess.exception.GameNotFoundException;
import com.capgemini.chess.service.dao.GameDao;
@Repository
public class GameDaoImpl implements GameDao {
	// stub
	private Set<GameEntity> games = new HashSet<GameEntity>(); 
	
	public GameDaoImpl() {
		createFewGames();
	}
	
	@Override
	public List<GameEntity> getAllUnfinishedGames() {
		List<GameEntity> unfinishedGames = new ArrayList<GameEntity>();
		for (GameEntity game : games) {
			if (game.getState() == Result.NOT_FINISHED) {
				unfinishedGames.add(game);
			}
		}
		return unfinishedGames;
	}

	@Override
	public GameEntity updateGame(GameEntity game) throws GameNotFoundException {
		GameEntity gameToUpdate = getGameById(game.getId());
		games.remove(gameToUpdate);
		games.add(game);
		return game;
	}

	@Override
	public void deleteGame(GameEntity game) throws GameNotFoundException {
		GameEntity gameToDelete = getGameById(game.getId());
		games.remove(gameToDelete);
	}

	@Override
	public GameEntity addGame(GameEntity game) {
		games.add(game);
		return game;
	}

	@Override
	public GameEntity getGameById(long gameId) throws GameNotFoundException {
		for (GameEntity game : games) {
			if (game.getId() == gameId) {
				return game;
			}
		}
		throw new GameNotFoundException();
	}

	private void createFewGames() {
		games.add(new GameEntity(1L, 112L, 113L, new DateTime().minusMinutes(5), 112L, Result.NOT_FINISHED));
		games.add(new GameEntity(10L, 15L, 113L, new DateTime().minusHours(2), 15L, Result.NOT_FINISHED));
		games.add(new GameEntity(100L, 15L, 113L, new DateTime().minusHours(4), 15L, Result.BLACK_WON));
		games.add(new GameEntity(11L, 112L, 11L, new DateTime().minusHours(3), 11L, Result.NOT_FINISHED));
	}


}
