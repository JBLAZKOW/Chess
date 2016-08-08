package com.capgemini.chess.service.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.exception.GameNotFoundException;

/**
 * @author JBLAZKOW
 *
 */
public interface GameDao {
	
	/**
	 * @param game to update
	 * @return updated game
	 * @throws GameNotFoundException
	 */
	GameEntity updateGame(GameEntity game) throws GameNotFoundException;
	/**
	 * @param game to delete
	 * @throws GameNotFoundException
	 */
	void deleteGame(GameEntity game) throws GameNotFoundException;
	/**
	 * @param game to add
	 * @return added game
	 */
	GameEntity addGame(GameEntity game);
	/**
	 * @param gameId 
	 * @return found game by id
	 * @throws GameNotFoundException
	 */
	GameEntity getGameById(long gameId) throws GameNotFoundException;
	/**
	 * @return all unfinished games
	 */
	List<GameEntity> getAllUnfinishedGames();
}
