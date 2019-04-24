package object;

import java.awt.*;
import java.util.ArrayList;

public class MyUseCase extends MyElements {
	
	private Point f1;
	private Point f2;
	
	public MyUseCase(Point clickPoint, int i) {
		coor = clickPoint;
		width = 150;
		height = 80;
		Selected = false;
		setIndex(i);
		setDepth(99-i);
		setMoved(false);
		setName("UseCase"+i);
		setComposited(false);
		Groupedby = new ArrayList<MyElements>();
		setFocus();	
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.BLACK);
		g2d.drawOval(coor.x, coor.y, width, height);
		g2d.drawString(getName(), coor.x+45, coor.y+45);
		
		setFocus();
		
		if (isSelected()) 
			toSelect(g);
	}
	

	@Override
	public boolean clickPointInArea(Point clickPoint) {
		int a = Math.max(width, height)/2;
		
		ClickWidth = clickPoint.x - coor.x;
		ClickHeight = clickPoint.y - coor.y;
		
		return (clickPoint.distance(f1) + clickPoint.distance(f2) <= 2*a); 
	}
	
	public void setFocus() {
		int a = Math.max(width, height)/2;
		int b = Math.min(width, height)/2;
		double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
		
		if (width > height) {
			f1 = new Point((int) (coor.x + width/2 + c), coor.y + height/2);
			f2 = new Point((int) (coor.x + width/2 - c), coor.y + height/2);
		} else {
			f1 = new Point(coor.x + width/2, (int) (coor.y + height/2 + c));
			f2 = new Point(coor.x + width/2, (int) (coor.y + height/2 - c));
		}
	}
}
