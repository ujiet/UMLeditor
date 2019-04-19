package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class MySelectionRect extends MyElements {
	
	public MySelectionRect(Point clickPoint) {
		coor = clickPoint;
		width = 0;
		height = 0;
		setIndex(0);
		setDepth(0);
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fillRect(coor.x, coor.y, width, height);
	}
	
	@Override
	public void toSelect(Graphics g) {}
	
	@Override
	public boolean clickPointInArea(Point clickPoint) {return false;}
}
