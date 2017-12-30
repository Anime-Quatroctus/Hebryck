package dev.anime.game;

import dev.anime.game.gfx.Display;

public class Game implements Runnable {
	
	private boolean running = false;
	private Thread thread;
	
	private Display display;
	
	public Game() {
		init();
	}
	
	public void init() {
		display = new Display("Title", 620, 540);
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
		while (running) {
			
		}
		this.stop();
	}
	
}
