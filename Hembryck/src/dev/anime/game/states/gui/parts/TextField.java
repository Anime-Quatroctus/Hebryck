package dev.anime.game.states.gui.parts;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class TextField  extends GuiPart {
	
	private StringBuilder builder = new StringBuilder();
	private int timer = 0;
	
	public TextField(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void renderPart(Graphics g) {
		g.drawString(builder.toString() + (timer >= 10 ? "_" : ""), x, y);
	}

	@Override
	public void tickPart() {
		timer++;
		if (timer == 21) timer = 0;
	}
	
	@Override
	public void keyTyped(int keyCode, char keyChar) {
		super.keyTyped(keyCode, keyChar);
		if (keyCode == KeyEvent.VK_BACK_SPACE) {
			if (builder.length() > 0) builder.deleteCharAt(builder.length() - 1);
		} else if (Character.isDefined(keyChar)) builder.append(keyChar);
	}

}
