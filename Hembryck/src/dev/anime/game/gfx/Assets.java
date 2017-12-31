package dev.anime.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage MAIN_MENU;
	
	public static void init() {
		MAIN_MENU = ImageHandler.loadImage("/images/menu/main.png");
	}
	
}
