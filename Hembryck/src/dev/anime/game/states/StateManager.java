package dev.anime.game.states;

public class StateManager {
	
	private static State currentState;
	private static State lastState;
	
	public static State getCurrentState() {
		return currentState;
	}
	
	public static State getLastState() {
		return lastState;
	}
	
	public static void setCurrentState(State newState) {
		lastState = currentState;
		currentState = newState;
	}
	
}
