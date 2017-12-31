package dev.anime.game.states.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import dev.anime.game.states.gui.parts.GuiPart;

public abstract class Gui {
	
	protected int x, y, width, height;
	protected List<GuiPart> parts = new ArrayList<GuiPart>();
	
	public abstract void renderGui(Graphics g);
	
	public abstract void tick();
	
	public void keyTyped(int keyCode, char keyChar) { }
	
}
