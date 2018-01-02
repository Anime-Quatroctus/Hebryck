package dev.anime.game.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import dev.anime.game.GameObjects;
import dev.anime.game.Utilities.Tuple;
import dev.anime.game.states.gui.Gui;

public abstract class State {
	
	public static State MAIN_MENU_STATE;
	public static State WORLD_STATE;
	
	protected GameObjects handler;
	protected List<Gui> guis = new ArrayList<Gui>();
	
	public State(GameObjects handler) {
		this.handler = handler;
	}
	
	public abstract void renderState(Graphics g);
	
	public abstract void tickState();
	
	private static final long TIME = (3000000000L / 4L);
	private static final Tuple<Character, Long, Boolean> key = new Tuple<Character, Long, Boolean>();
	
	public void keyPressed(int keyCode, char keyChar) {
		if (key.getKey() != null && key.getKey() == ((char) keyCode)) {
			long lastTime = key.getValue1(), currentTime = System.nanoTime();
			if (key.getValue2() == true) {
				if (currentTime - lastTime >= TIME / 3) {
					this.keyTyped(keyCode, keyChar);
				}
			} else if (currentTime - lastTime >= TIME) {
				this.keyTyped(keyCode, keyChar);
				key.put((char)keyCode, lastTime + TIME, true);
			}
		} else {
			key.put((char) keyCode, System.nanoTime(), false);
			this.keyTyped(keyCode, keyChar);
		}
	}
	
	public void keyReleased(int keyCode, char keyChar) {
		key.put(null, null, null);
	}
	
	public void keyTyped(int keyCode, char keyChar) {
		if (keyChar == '`') handler.getGame().switchDebug();
	}
	
	public void mouseClicked(int button, int x, int y) { }
	
	public void mouseEntered(int button, int x, int y) {
//		handler.getGame().setPaused(false);
	}
	
	public void mouseExited(int button, int x, int y) {
//		handler.getGame().setPaused(true);
	}
	
	public void mousePressed(int button, int x, int y) { }
	
	public void mouseReleased(int button, int x, int y) { }
	
	public void mouseDragged(int button, int x, int y) { }
	
	public void mouseMoved(int button, int x, int y) { }
	
	public void mouseWheelMoved(int count, int x, int y) { }
	
}
