package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class MyCompLine extends MyLines {

	public MyCompLine(Point clickPoint, MyElements StartElement) {
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
		
		int l = 10;
		double deg = getRadian(start, end);
		Point p1 = getRotatedPoint(start, deg-Math.PI/6.0d, l);
		Point p2 = getRotatedPoint(start, deg+Math.PI/6.0d, l);
		Point ps = getRotatedPoint(start, deg, l*Math.sqrt(3));
		
		int[] Xs = new int[] {start.x, p1.x, ps.x, p2.x};
		int[] Ys = new int[] {start.y, p1.y, ps.y, p2.y};

		g2d.drawPolygon(Xs, Ys, 4);
		g2d.drawLine(ps.x, ps.y, end.x, end.y);
	}
	
}
