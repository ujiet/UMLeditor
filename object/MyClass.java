package object;

import java.awt.*;
import java.util.ArrayList;

public class MyClass extends MyElements {
	
	public MyClass(Point clickPoint, int i) {
		coor = clickPoint;
		width = 100;
		height = 160;
		Selected = false;
		setIndex(i);
		setDepth(99-i);
		setMoved(false);
		setName("Class"+i);
		setComposited(false);
		Groupedby = new ArrayList<MyElements>();
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int TextHeight = 20;
		g2d.setPaint(Color.BLACK);
		g2d.drawRect(coor.x, coor.y, width, height);
		g2d.drawLine(coor.x, coor.y+TextHeight, coor.x+width, coor.y+TextHeight);
		g2d.drawLine(coor.x, coor.y+TextHeight/2+height/2, coor.x+width, coor.y+TextHeight/2+height/2);
		g2d.drawString(getName(), coor.x+5, coor.y+TextHeight-4);
		
		if (isSelected()) 
			toSelect(g);
	}
	
	@Override
	public boolean clickPointInArea(Point clickPoint) {
		ClickWidth = clickPoint.x - coor.x;
		ClickHeight = clickPoint.y - coor.y;
		
		return (coor.x <= clickPoint.x && clickPoint.x < coor.x+width && coor.y <= clickPoint.y && clickPoint.y < coor.y+height); 
	}
	
}
