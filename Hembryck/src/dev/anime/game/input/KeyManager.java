package dev.anime.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.anime.game.states.StateManager;

public class KeyManager implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent event) {
		StateManager.getCurrentState().keyPressed(event.getKeyCode(), event.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent event) {
		StateManager.getCurrentState().keyReleased(event.getKeyCode(), event.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent event) { }

}
