package dev.anime.game.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import dev.anime.game.GameObjects;

public class ScaledGraphics extends Graphics {
	
	private Graphics g;
	private GameObjects handler;
	
	public ScaledGraphics(Graphics g, GameObjects handler) {
		this.g = g;
		this.handler = handler;
	}
	
	@Override
	public void clearRect(int x, int y, int width, int height) {
		g.clearRect((int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()));
	}

	@Override
	public void clipRect(int x, int y, int width, int height) {
		g.clipRect((int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()));
	}

	@Override
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
	}

	@Override
	public Graphics create() {
		return new ScaledGraphics(g.create(), handler);
	}

	@Override
	public void dispose() {
		g.dispose();
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		
	}

	@Override
	public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
		return g.drawImage(img, (int) (x * handler.getXScale()), (int) (y * handler.getYScale()), observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
		return g.drawImage(img, (int) (x * handler.getXScale()), (int) (y * handler.getYScale()), bgcolor, observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
		return g.drawImage(img, (int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()), observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
		return g.drawImage(img, (int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()), bgcolor, observer);
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
		return false;
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
		return false;
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine((int) (x1 * handler.getXScale()), (int) (y1 * handler.getYScale()), (int) (x2 * handler.getXScale()), (int) (y2 * handler.getYScale()));
	}

	@Override
	public void drawOval(int x, int y, int width, int height) { }

	@Override
	public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) { }

	@Override
	public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) { }

	@Override
	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g.drawRoundRect((int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()), (int) (arcWidth * handler.getXScale()), (int) (arcHeight * handler.getYScale()));
	}

	@Override
	public void drawString(String str, int x, int y) {
		g.drawString(str, (int) (x * handler.getXScale()), (int) (y * handler.getYScale()) + getFontMetrics().getAscent() - getFontMetrics().getDescent());
	}

	@Override
	public void drawString(AttributedCharacterIterator iterator, int x, int y) { }

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) { }

	@Override
	public void fillOval(int x, int y, int width, int height) { }

	@Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) { }

	@Override
	public void fillRect(int x, int y, int width, int height) {
		g.fillRect((int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()));
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g.fillRoundRect((int) (x * handler.getXScale()), (int) (y * handler.getYScale()), (int) (width * handler.getXScale()), (int) (height * handler.getYScale()), (int) (arcWidth * handler.getXScale()), (int) (arcHeight * handler.getYScale()));
	}

	@Override
	public Shape getClip() {
		return g.getClip();
	}

	@Override
	public Rectangle getClipBounds() {
		return g.getClipBounds();
	}

	@Override
	public Color getColor() {
		return g.getColor();
	}

	@Override
	public Font getFont() {
		return g.getFont();
	}

	@Override
	public FontMetrics getFontMetrics(Font f) {
		return g.getFontMetrics(f);
	}

	@Override
	public void setClip(Shape clip) {
		g.setClip(clip);
	}

	@Override
	public void setClip(int x, int y, int width, int height) { }

	@Override
	public void setColor(Color c) {
		g.setColor(c);
	}

	@Override
	public void setFont(Font font) {
		g.setFont(font);
	}

	@Override
	public void setPaintMode() {
		g.setPaintMode();
	}

	@Override
	public void setXORMode(Color c1) {
		g.setXORMode(c1);
	}

	@Override
	public void translate(int x, int y) {
		g.translate((int) (x * handler.getXScale()), (int) (y * handler.getYScale()));
	}
	
}
