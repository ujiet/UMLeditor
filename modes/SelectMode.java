package modes;

import java.awt.Point;

import java.util.ArrayList;
import object.*;

public class SelectMode extends BasicMode {
	private SelectMode() {}
	
	public static void clickSelect(Point clickPoint, ArrayList<MyElements> elements) {
		boolean SelectFinished = false;
		
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
	
	public static void pressSelect(Point clickPoint, ArrayList<MyElements> elements) {
		
		MyElements selection = ((MyArrayList) elements).getSelectionRect();

		selection.setCoor(clickPoint.x, clickPoint.y);
	}
	
	public static void dragSelect(Point clickPoint, Point dragPoint, ArrayList<MyElements> elements) {
		
		if (!((MyArrayList) elements).isMoving()) {
		
			MyElements selection = ((MyArrayList) elements).getSelectionRect();
			
			selection.setCoor(Math.min(clickPoint.x, dragPoint.x), Math.min(clickPoint.y, dragPoint.y));
			selection.setWidth(Math.max(clickPoint.x, dragPoint.x) - selection.getCoor().x);
			selection.setHeight(Math.max(clickPoint.y, dragPoint.y) - selection.getCoor().y);
		}

	}
	
	public static void releaseSelect(ArrayList<MyElements> elements) {
		
		MyElements selection = ((MyArrayList) elements).getSelectionRect();
		
		for (MyElements e: elements) {
			e.checkInSelection(selection);
		}
		
		selection.setWidth(0);
		selection.setHeight(0);
		
	}
	
	public static void pressMove(Point clickPoint, ArrayList<MyElements> list) {
		
		MyArrayList elements = (MyArrayList) list;
		MyElements TopObject = elements.getToppestClickedObject(clickPoint);
		
		if (TopObject != null) {
			TopObject.setMoved(true);			
			if (TopObject.isComposited()) {
				for (Integer i:((MyComposite) TopObject).getComponents()) {
					//System.out.print(e.getName()+" ");
					elements.get(i).setMoved(true);
				}
			}
			elements.setMoving(true);
			//System.out.println();
		}
	}
	
	public static void dragMove(Point clickPoint, Point dragPoint, ArrayList<MyElements> list) {
		MyArrayList elements = (MyArrayList) list;
		
		if (elements.isMoving()) {
			for (MyElements e: elements) {
				if (e.isMoved())
					e.setCoor(dragPoint.x - e.getClickWidth(), dragPoint.y - e.getClickHeight());
			}
		}
	}
	
	public static void releaseMove(ArrayList<MyElements> list) {
		MyArrayList elements = (MyArrayList) list;
		
		if (elements.isMoving()) {
			for (MyElements e: elements) 
				e.setMoved(false);
		}
		
		elements.setMoving(false);
	}
	
	//e.setCoor(dragPoint.x - e.getClickWidth(), dragPoint.y - e.getClickHeight());
}
