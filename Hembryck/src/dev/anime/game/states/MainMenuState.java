package dev.anime.game.states;

import java.awt.Color;
import java.awt.event.KeyEvent;

import dev.anime.game.GameObjects;
import dev.anime.game.gfx.Assets;
import dev.anime.game.gfx.ScaledGraphics;

public class MainMenuState extends State {
	
	private int timer = 0;
	private StringBuilder builder = new StringBuilder();
	
	public MainMenuState(GameObjects handler) {
		super(handler);
	}

	@Override
	public void renderState(ScaledGraphics g) {
		g.drawImage(Assets.MAIN_MENU, 0, 0, handler.getWidth(), handler.getHeight(), null);
		g.setColor(Color.GREEN);
		g.drawString(builder.toString() + (timer >= 10 ? "_" : ""), 0, 460);
	}

	@Override
	public void tickState() {
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
