package object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class MyGenLine extends MyLines {

	public MyGenLine(Point clickPoint, MyElements StartElement) {
		setStart(clickPoint, StartElement);
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Point start = getStartElement().getConnectPoint(getStartDir());
		Point end;
		
		if (isDragged())
			end = getEndPoint();
		else
			end = getEndElement().getConnectPoint(getEndDir());
		
		int l = 10;
		int[] Xs = new int[] {start.x, start.x+l, start.x+l};
		int[] Ys = new int[] {start.y, start.y+l/2, start.y-l/2};
		
		g2d.drawLine(start.x, start.y, end.x, end.y);
		g2d.drawPolygon(Xs, Ys, 3);
		g2d.fillRect(start.x-l/2, start.y-l/2, l, l);
		g2d.fillRect(end.x-l/2, end.y-l/2, l, l);
	}
	
	/*
	private class Triangle {
		Triangle() {
			
		}
	}
	*/
}
