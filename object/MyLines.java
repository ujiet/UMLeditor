package object;

import java.awt.Graphics;
import java.awt.Point;

public abstract class MyLines {
	protected Point StartPoint;
	protected Point EndPoint;
	protected MyElements StartElement;
	protected MyElements EndElement;
	protected String StartDir;
	protected String EndDir;
	protected String Name;
	protected boolean Dragged;
	
	public abstract void update(Graphics g);
	
	public Point getStartPoint() {return StartPoint;}
	public void setStartPoint(Point p) {StartPoint = p;}
	public Point getEndPoint() {return EndPoint;}
	public void setEndPoint(Point p) {EndPoint = p;}
	public String getName() {return Name;}
	public void setName(String n) {Name = n;}
	public MyElements getStartElement() {return StartElement;}
	public void setStartElement(MyElements e) {StartElement = e;}
	public MyElements getEndElement() {return EndElement;}
	public void setEndElement(MyElements e) {EndElement = e;}
	public String getStartDir() {return StartDir;}
	public void setStartDir(String s) {StartDir = s;}
	public String getEndDir() {return EndDir;}
	public void setEndDir(String s) {EndDir = s;}
	public boolean isDragged() {return Dragged;}
	public void setDragged(boolean flag) {Dragged = flag;}
	
	public void setStart(Point clickPoint, MyElements StartElement) {
		setStartElement(StartElement);
		setStartPoint(clickPoint);
		setStartDir(StartElement.getConnectDir(clickPoint));
		setDragged(true);
	}
	
	public void setEnd(Point clickPoint, MyElements EndElement) {
		setEndElement(EndElement);
		setEndPoint(clickPoint);
		setEndDir(EndElement.getConnectDir(clickPoint));
		setDragged(false);
	}

}
