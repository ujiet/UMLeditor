package object;

import java.awt.Graphics;
import java.awt.Point;

public abstract class MyLines {
	protected Point StartPoint;
	protected Point EndPoint;
	protected String Name;
	
	public Point getStartPoint() {return StartPoint;}
	public void setStartPoint(Point p) {StartPoint = p;}
	public Point getEndPoint() {return EndPoint;}
	public void setEndPoint(Point p) {EndPoint = p;}
	public String getName() {return Name;}
	public void setName(String n) {Name = n;}
	
	public abstract void update(Graphics g);
}
