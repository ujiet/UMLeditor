package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class MyAssocLine extends MyLines {

	public MyAssocLine(Point clickPoint, MyElements StartElement) {
		setStart(clickPoint, StartElement);
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.black);
		
		Point start = getStartElement().getConnectPoint(getStartDir());
		Point end;
		
		if (isDragged())
			end = getEndPoint();
		else
			end = getEndElement().getConnectPoint(getEndDir());
		
		g2d.drawLine(start.x, start.y, end.x, end.y);
	}
	
}
