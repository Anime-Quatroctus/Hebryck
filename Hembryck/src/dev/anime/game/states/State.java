package dev.anime.game.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import dev.anime.game.GameObjects;
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
	
}
