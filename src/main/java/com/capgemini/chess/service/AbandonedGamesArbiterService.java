package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.GameEntity;
import com.capgemini.chess.exception.GameNotFoundException;

/**
 * @author JBLAZKOW
 * AbandonedGamesArbiterService provides possibility to check from unfinished games if they are expired and
 * change them result to last player moving as a loser, also update all changed games
 */
public interface AbandonedGamesArbiterService {
	
	List<GameEntity> arbiterAbandonedGames() throws GameNotFoundException;
	
}
