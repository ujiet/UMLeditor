package object;

import java.awt.*;
import java.util.ArrayList;

public class MyComposite extends MyElements{
	
	private ArrayList<Integer> Components;
	private ArrayList<MyElements> elements;
	
	public MyComposite(ArrayList<MyElements> ElementsList) {
		
		elements = ElementsList;
		Components = new ArrayList<Integer>();
		setComponents(elements);
		setSelected(true);
		setIndex(elements.size());
		setDepth(99-getIndex());
		setMoved(false);
		setName("Composite"+getIndex());
		setCompositeEdge();
		setComposited(true);

		Groupedby = new ArrayList<MyElements>();
	}
	
	@Override
	public void update(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.RED);
		g2d.drawRect(coor.x, coor.y, width, height);
		g2d.drawString(getName(), coor.x, coor.y);
		
		if (isSelected()) 
			toSelect(g);
	};
	
	public void setCompositeEdge() {
		
		/* get min and max */
		MyElements e = elements.get(Components.get(0));
		int Xmin, Xmax, Ymin, Ymax;
		Xmin = e.getCoor().x;
		Ymin = e.getCoor().y;
		Xmax = e.getCoor().x + e.getWidth();
		Ymax = e.getCoor().y + e.getHeight();
		
		for (int i = 0; i < Components.size(); i++) {		
			e = elements.get(Components.get(i));
			if (e.getCoor().x < Xmin) Xmin = e.getCoor().x;
			if (e.getCoor().x + e.getWidth() > Xmax) Xmax = e.getCoor().x + e.getWidth();
			if (e.getCoor().y < Ymin) Ymin = e.getCoor().y;
			if (e.getCoor().y + e.getHeight() > Ymax) Ymax = e.getCoor().y + e.getHeight();
		}
		
		/* set coor and width and height */
		setCoor(Xmin, Ymin);
		setWidth(Math.max(Xmax - Xmin, Ymax - Ymin));
		setHeight(Math.max(Xmax - Xmin, Ymax - Ymin));
	}
	
	public ArrayList<Integer> getComponents() {
		return Components;
	}
	

	public void setComponents(ArrayList<MyElements> elements) {
		for (int i = 0; i < elements.size(); i++) {
			MyElements e =  elements.get(i);
			if (e.isSelected()) {
				Components.add(i);
				e.setSelected(false);
				e.Groupedby.add(this);
				
				if (e.isComposited()) {
					ArrayList<Integer> list = ((MyComposite) e).getComponents();
					for (int c: list) {
						elements.get(c).Groupedby.add(this);
					}
					Components.addAll(list);
				}
			}
		}
	}
	
	public void printComponents() {
		System.out.print(this.getName()+"'s components are: ");
		for (int e: Components)
			System.out.print(elements.get(e).getName()+" ");
		System.out.println();
	}
	
	@Override
	public boolean clickPointInArea(Point clickPoint) {
		ClickWidth = clickPoint.x - coor.x;
		ClickHeight = clickPoint.y - coor.y;
		
		return (coor.x <= clickPoint.x && clickPoint.x < coor.x+width && coor.y <= clickPoint.y && clickPoint.y < coor.y+height); 
	}
	
}
