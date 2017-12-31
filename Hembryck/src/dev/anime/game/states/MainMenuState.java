package dev.anime.game.states;

import java.awt.Graphics;

import dev.anime.game.GameObjects;
import dev.anime.game.gfx.Assets;

public class MainMenuState extends State {
	
	public MainMenuState(GameObjects handler) {
		super(handler);
	}

	@Override
	public void renderState(Graphics g) {
		g.drawImage(Assets.MAIN_MENU, 0, 0, handler.getWidth(), handler.getHeight(), null);
	}

	@Override
	public void tickState() { }
	
	@Override
	public void keyTyped(int keyCode, char keyChar) {
		super.keyTyped(keyCode, keyChar);
	}
	
}
