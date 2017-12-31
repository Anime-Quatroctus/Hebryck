package dev.anime.game.states.gui.parts;

import java.awt.Graphics;

public abstract class GuiPart {
	
	public int x, y, width, height;
	
	public GuiPart(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void renderPart(Graphics g);
	
	public abstract void tickPart();
	
	public void keyTyped(int keyCode, char keyChar) { }
	
}
