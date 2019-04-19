package object;

import java.awt.*;
import java.util.ArrayList;

public abstract class MyElements {
	protected Point coor;
	protected int Index;
	protected int depth;
	protected int width;
	protected int height;
	protected boolean Selected;
	protected boolean Moved;
	protected boolean Composited;
	protected int ClickWidth;
	protected int ClickHeight;
	protected String Name;
	
	public ArrayList<MyElements> Groupedby;
	
	public abstract void update(Graphics g);
	public abstract boolean clickPointInArea(Point clickPoint);
	
	public Point getCoor() {return coor;}
	public void setCoor(int x, int y) {coor = new Point(x, y);}
	public int getWidth() {return width;}
	public void setWidth(int w) {width = w;}
	public int getHeight() {return height;}
	public void setHeight(int h) {height = h;}
	public int getDepth() {return depth;}
	public void setDepth(int d) {depth = d;}
	public int getIndex() {return Index;}
	public void setIndex(int i) {Index = i;}
	public boolean isSelected() {return Selected;}
	public void setSelected(boolean flag) {Selected = flag;}
	public boolean isMoved() {return Moved;}
	public void setMoved(boolean flag) {Moved = flag;}
	public ArrayList<MyElements> getGroupedby() {return Groupedby;}
	public boolean isComposited() {return Composited;}
	public void setComposited(boolean flag) {Composited = flag;}
	public int getClickWidth() {return ClickWidth;}
	public void setClickWidth(int w) {ClickWidth = w;}
	public int getClickHeight() {return ClickHeight;}
	public void setClickHeight(int h) {ClickHeight = h;}
	public String getName() {return Name;}
	public void setName(String n) {Name = n;}
	
	public void toSelect(Graphics g) {
		int l = 12;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(coor.x+width/2-l/2, coor.y-l/2, l, l);
		g2d.fillRect(coor.x+width/2-l/2, coor.y+height-l/2, l, l);
		g2d.fillRect(coor.x-l/2, coor.y+height/2-l/2, l, l);
		g2d.fillRect(coor.x+width-l/2, coor.y+height/2-l/2, l, l);
	}
	
	public void checkInSelection(MyElements s) {
		if (getCoor().x >= s.getCoor().x && getCoor().y >= s.getCoor().y &&
				getCoor().x+getWidth() < s.getCoor().x+s.getWidth() && getCoor().y+getHeight() < s.getCoor().y+s.getHeight() &&
				getGroupedby().isEmpty())
			setSelected(true);
		else 
			setSelected(false);
	}
	
	public boolean clickInUpRight(Point clickPoint) {
		
		int x = clickPoint.x - coor.x;
		int y = clickPoint.y - coor.y;
		
		return (height*x - width*y > 0);
	}
	
	public boolean clickInDownRight(Point clickPoint) {
		
		int x = clickPoint.x - coor.x;
		int y = clickPoint.y - coor.y;
		
		return (height*x + width*y - height*width > 0);
	}
	
	public Point getRightPoint() {
		return (new Point(coor.x+width, coor.y+height/2));
	}
	
	public Point getLeftPoint() {
		return (new Point(coor.x, coor.y+height/2));
	}
	
	public Point getUpPoint() {
		return (new Point(coor.x+width/2, coor.y));
	}
	
	public Point getDownPoint() {
		return (new Point(coor.x+width/2, coor.y+height));
	}
	
	public Point getConnectPoint(Point clickPoint) {
		
		if (clickInUpRight(clickPoint) && clickInDownRight(clickPoint))  // right
			return getRightPoint();
		if (!clickInUpRight(clickPoint) && clickInDownRight(clickPoint))  // down
			return getDownPoint();
		if (!clickInUpRight(clickPoint) && !clickInDownRight(clickPoint))  // left
			return getLeftPoint();
		if (clickInUpRight(clickPoint) && !clickInDownRight(clickPoint))  // up
			return getUpPoint();
		
		return null;
	}	
	
	public Point getConnectPoint(String s) {
		
		switch (s) {
			case "Right":
				return getRightPoint();
			case "Left":
				return getLeftPoint();
			case "Up":
				return getUpPoint();
			case "Down":
				return getDownPoint();
			default:
				return null;
		}
	}
	
	public String getConnectDir(Point clickPoint) {
		
		if (clickInUpRight(clickPoint) && clickInDownRight(clickPoint))  // right
			return "Right";
		if (!clickInUpRight(clickPoint) && clickInDownRight(clickPoint))  // down
			return "Down";
		if (!clickInUpRight(clickPoint) && !clickInDownRight(clickPoint))  // left
			return "Left";
		if (clickInUpRight(clickPoint) && !clickInDownRight(clickPoint))  // up
			return "Up";
		
		return null;
	}
}
