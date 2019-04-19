package object;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class MyLines implements Serializable {
	protected Point StartPoint;
	protected Point EndPoint;
	protected String Name;
	
	public Point getStartPoint() {return StartPoint;}
	public void setStartPoint(int x, int y) {StartPoint = new Point(x, y);}
	public Point getEndPoint() {return EndPoint;}
	public void setEndPoint(int x, int y) {EndPoint = new Point(x, y);}
	public String getName() {return Name;}
	public void setName(String n) {Name = n;}
	
	public abstract void update(Graphics g);
}
