package com.capgemini.chess.dataaccess.entities;

import org.joda.time.DateTime;

import com.capgemini.chess.enums.Result;

public class GameEntity {
	private long id;
	private long whitePlayerId;
	private long blackPlayerId;
	private DateTime lastMoveTime;
	private long playerIdTurn;
	private Result state;
	
	public GameEntity() {
		
	}
	
	public GameEntity(final long id, final long player1Id, final long player2Id, 
			final DateTime lastMoveTime, final long playerIdTurn, final Result state) {
		this.id = id;
		this.whitePlayerId = player1Id;
		this.blackPlayerId = player2Id;
		this.lastMoveTime = lastMoveTime;
		this.playerIdTurn = playerIdTurn;
		this.state = state;
	}
	
	public final long getId() {
		return id;
	}
	
	public final long getWhitePlayerId() {
		return whitePlayerId;
	}

	public final void setWhitePlayerId(final long whitePlayerId) {
		this.whitePlayerId = whitePlayerId;
	}

	public final long getBlackPlayerId() {
		return blackPlayerId;
	}

	public final void setBlackPlayerId(final long blackPlayerId) {
		this.blackPlayerId = blackPlayerId;
	}

	public final void setId(final long id) {
		this.id = id;
	}
	public final Result getState() {
		return state;
	}
	public final void setState(final Result state) {
		this.state = state;
	}

	public final DateTime getLastMoveTime() {
		return lastMoveTime;
	}

	public final void setLastMoveTime(final DateTime lastMoveTime) {
		this.lastMoveTime = lastMoveTime;
	}

	public final long getPlayerIdTurn() {
		return playerIdTurn;
	}

	public final void setPlayerIdTurn(final long playerIdTurn) {
		this.playerIdTurn = playerIdTurn;
	}
	
}
