package modes;

import java.awt.Point;

import java.util.ArrayList;
import object.*;

public class SelectMode extends BasicMode {
	private SelectMode() {}
	
	public static void clickSelect(Point clickPoint, MyObjects Objects) {
		boolean SelectFinished = false;
		ArrayList<MyElements> elements = Objects.getElements();
		
		for (int i = elements.size()-1; i >= 0; i--) {
			
			e = (MyElements) elements.get(i);
			
			if (e.clickPointInArea(clickPoint) && !SelectFinished) {
				e.setSelected(!e.isSelected());
				SelectFinished = true;
			} else {
				e.setSelected(false);
			}
		}
	}
	
	public static void pressSelect(Point clickPoint, MyObjects Objects) {
		
		MyElements selection = Objects.getSelectionRect();

		selection.setCoor(clickPoint.x, clickPoint.y);
	}
	
	public static void dragSelect(Point clickPoint, Point dragPoint, MyObjects Objects) {
		
		if (!Objects.isMoving()) {
		
			MyElements selection = Objects.getSelectionRect();
			
			selection.setCoor(Math.min(clickPoint.x, dragPoint.x), Math.min(clickPoint.y, dragPoint.y));
			selection.setWidth(Math.max(clickPoint.x, dragPoint.x) - selection.getCoor().x);
			selection.setHeight(Math.max(clickPoint.y, dragPoint.y) - selection.getCoor().y);
		}

	}
	
	public static void releaseSelect(MyObjects Objects) {
		
		MyElements selection = Objects.getSelectionRect();
		
		for (MyElements e: Objects.getElements()) {
			e.checkInSelection(selection);
		}
		
		selection.setWidth(0);
		selection.setHeight(0);
		
	}
	
	public static void pressMove(Point clickPoint, MyObjects Objects) {
		
		MyElements TopObject = Objects.getToppestClickedElement(clickPoint);
		
		if (TopObject != null) {
			TopObject.setMoved(true);			
			if (TopObject.isComposited()) {
				for (Integer i:((MyComposite) TopObject).getComponents()) {
					//System.out.print(e.getName()+" ");
					Objects.getElements().get(i).setMoved(true);
				}
			}
			Objects.setMoving(true);
			//System.out.println();
		}
	}
	
	public static void dragMove(Point clickPoint, Point dragPoint, MyObjects Objects) {
		
		if (Objects.isMoving()) {
			for (MyElements e: Objects.getElements()) {
				if (e.isMoved())
					e.setCoor(dragPoint.x - e.getClickWidth(), dragPoint.y - e.getClickHeight());
			}
		}
	}
	
	public static void releaseMove(MyObjects Objects) {
		
		if (Objects.isMoving()) {
			for (MyElements e: Objects.getElements()) 
				e.setMoved(false);
		}
		
		Objects.setMoving(false);
	}
	
	//e.setCoor(dragPoint.x - e.getClickWidth(), dragPoint.y - e.getClickHeight());
}
