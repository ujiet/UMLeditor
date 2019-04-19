package object;

import java.awt.Point;
import java.util.ArrayList;

public class MyObjects {
	private int SelectedAmount;
	private MySelectionRect Selection;
	private boolean Moving;
	
	private ArrayList<MyLines> Lines;
	private ArrayList<MyElements> Elements;
	private MyLines TempLine;
	
	public MyObjects() {
		setSelectedAmount(0);
		setMoving(false);
		Selection = new MySelectionRect(new Point(0, 0));
		Lines = new ArrayList<MyLines>();
		Elements = new ArrayList<MyElements>();
	}
	
	public void setSelectedAmount(int n) {
		SelectedAmount = n;
	}
	
	public void setMoving(boolean flag) {
		Moving = flag;
	}
	
	public boolean isMoving() {
		return Moving;
	}
	
	public MySelectionRect getSelectionRect() {
		return Selection;
	}
	
	public ArrayList<MyLines> getLines() {
		return Lines;
	}
	
	public ArrayList<MyElements> getElements() {
		return Elements;
	}
	
	public MyLines getTempLine() {
		return TempLine;
	}
	
	public void createTempLine(MyLines l) {
		TempLine = l;
	}
	
	public void clearTempLine() {
		TempLine = null;
	}
	
	public void setTempLineStartPoint(Point p) {
		TempLine.setStartPoint(p);
	}
	
	public void setTempLineEndPoint(Point p) {
		TempLine.setEndPoint(p);
	}
	
	public int getSelectedAmount() {	
		setSelectedAmount(0);
		for (int i = 0; i < Elements.size(); i++) 
			if (Elements.get(i).isSelected())
				SelectedAmount++;
		return SelectedAmount;
	}
	
	public int getFirstSelectedIndex() {
		for (int i = 0; i < Elements.size(); i++)
			if (Elements.get(i).isSelected())
				return i;
		return 0;
	}

	
	public MyElements getToppestClickedElement(Point clickPoint) {
		MyElements Top = null;
		
		for (int i = 0; i < Elements.size(); i++) {
			if (Elements.get(i).clickPointInArea(clickPoint))
				Top = Elements.get(i);
		}
		
		return Top;
	}
	
}
