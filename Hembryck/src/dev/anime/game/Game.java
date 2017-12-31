package dev.anime.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferStrategy;

import dev.anime.game.gfx.Assets;
import dev.anime.game.gfx.Display;
import dev.anime.game.gfx.ScaledGraphics;
import dev.anime.game.states.MainMenuState;
import dev.anime.game.states.State;
import dev.anime.game.states.StateManager;

public class Game implements Runnable {
	
	private int updates;
	private boolean running = false, showDebugInfo = false;
	private Thread thread;
	
	private Display display;
	private BufferStrategy bs;
	
	private GameObjects handler;
	
	public Game() {
		this.init();
	}
	
	public void init() {
		display = new Display("Title", 620, 540);
		handler = new GameObjects(this);
		State.MAIN_MENU_STATE = new MainMenuState(this.handler);
		StateManager.setCurrentState(State.MAIN_MENU_STATE);
		Assets.init();
	}
	
	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		if (!running) return;
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int updates = 0;
		double timePerUpdate = 1D / 30D, timeBetweenLastTick = 0;
		long lastTime = System.nanoTime();
		long currentTime, timePassed = 0;
		while (running) {
			currentTime = System.nanoTime();
			timeBetweenLastTick += ((currentTime - lastTime) / 1000000000D);
			if (timeBetweenLastTick >= timePerUpdate) {
				this.tick();
				this.render();
				timeBetweenLastTick -= timePerUpdate;
				updates++;
			}
			timePassed += currentTime - lastTime;
			if (timePassed > 1000000000) {
				this.updates = updates;
				updates = 0;
				timePassed -= 1000000000;
			}
			lastTime = currentTime;
		}
		this.stop();
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		ScaledGraphics g = new ScaledGraphics(bs.getDrawGraphics(), handler);
		
		g.clearRect(0, 0, display.getWidth(), display.getHeight());
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, display.getWidth(), display.getHeight());
		StateManager.getCurrentState().renderState(g);
		if (showDebugInfo) {
			g.setFont(new Font("arial", 0, 40));
			g.setColor(Utilities.getColorPercentage(updates, 30));
			g.drawString(Integer.toString(updates), 0, 0);
		}
		bs.show();
		g.dispose();
	}
	
	public void tick() {
		StateManager.getCurrentState().tickState();
	}
	
	public void switchDebug() {
		showDebugInfo = !showDebugInfo;
	}
	
	public Display getDisplay() {
		return display;
	}
	
}
