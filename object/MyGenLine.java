package object;

import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class MyGenLine extends MyLines {

	MyGenLine() {}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(StartPoint.x, StartPoint.y, EndPoint.x, EndPoint.y);
	}
}
