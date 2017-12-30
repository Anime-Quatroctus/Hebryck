package dev.anime.game.gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.anime.game.input.KeyManager;
import dev.anime.game.input.MouseManager;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private MouseManager mManager;
	private KeyManager kManager;
	
	public Display(String name, int width, int height) {
		this.createJFrame(name, width, height);
	}
	
	private void createJFrame(String name, int width, int height) {
		frame = new JFrame(name);
		Dimension dim = new Dimension(width, height);
		frame.setPreferredSize(dim);
		frame.setMinimumSize(dim);
		frame.setMaximumSize(dim);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
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
	
}
