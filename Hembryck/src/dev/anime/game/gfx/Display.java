package dev.anime.game.gfx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.anime.game.input.KeyManager;
import dev.anime.game.input.MouseManager;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private MouseManager mManager;
	private KeyManager kManager;
	
	private String name;
	private int width, height;
	
	public Display(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.createJFrame(name, width, height);
	}
	
	private void createJFrame(String name, int width, int height) {
		frame = new JFrame(name);
		Dimension dim = new Dimension(width, height);
		frame.setPreferredSize(dim);
		frame.setMinimumSize(dim);
		frame.setMaximumSize(dim);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.addMouseListener(mManager = new MouseManager());
		canvas.addMouseMotionListener(mManager);
		canvas.addMouseWheelListener(mManager);
		canvas.addKeyListener(kManager = new KeyManager());
		canvas.setFocusable(true);
		canvas.setPreferredSize(dim);
		canvas.setMinimumSize(dim);
		canvas.setMaximumSize(dim);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public KeyManager getKey() {
		return kManager;
	}
	
	public MouseManager getMouse() {
		return mManager;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getXScale() {
		return ((float) canvas.getWidth()) / ((float)this.width);
	}
	
	public float getYScale() {
		return ((float) canvas.getHeight()) / ((float)this.height);
	}
	
}
