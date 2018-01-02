package dev.anime.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputListener;

import dev.anime.game.states.StateManager;

public class MouseManager implements MouseInputListener, MouseMotionListener, MouseWheelListener {
	
	@Override
	public void mouseClicked(MouseEvent event) {
		StateManager.getCurrentState().mouseClicked(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		StateManager.getCurrentState().mouseEntered(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mouseExited(MouseEvent event) {
		StateManager.getCurrentState().mouseExited(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mousePressed(MouseEvent event) {
		StateManager.getCurrentState().mousePressed(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		StateManager.getCurrentState().mouseReleased(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		StateManager.getCurrentState().mouseWheelMoved(event.getWheelRotation(), event.getX(), event.getY());
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		StateManager.getCurrentState().mouseDragged(event.getButton(), event.getX(), event.getY());
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		StateManager.getCurrentState().mouseMoved(event.getButton(), event.getX(), event.getY());
	}
	
}
