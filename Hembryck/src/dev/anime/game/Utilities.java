package dev.anime.game;

import java.awt.Color;

public class Utilities {
	
	public static Color getColorPercentage(int current, int max) {
		double percentage = (double) (current / max);
		if (percentage > .6) return Color.GREEN;
		if (percentage > .2) return Color.YELLOW;
		return Color.RED;
	}
	
}
