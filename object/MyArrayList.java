package object;

import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyArrayList extends ArrayList<MyElements> {
	private static int SelectedAmount;
	private static MySelectionRect Selection;
	private static boolean Moving;
	
	public MyArrayList() {
		setSelectedAmount(0);
		setMoving(false);
		Selection = new MySelectionRect(new Point(0, 0));
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
	
	public int getSelectedAmount() {	
		setSelectedAmount(0);
		for (int i = 0; i < this.size(); i++) 
			if (this.get(i).isSelected())
				SelectedAmount++;
		return SelectedAmount;
	}
	
	public int getFirstSelectedIndex() {
		for (int i = 0; i < this.size(); i++)
			if (this.get(i).isSelected())
				return i;
		return 0;
	}

	
	public MyElements getToppestClickedObject(Point clickPoint) {
		MyElements Top = null;
		
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).clickPointInArea(clickPoint))
				Top = this.get(i);
		}
		
		return Top;
	}
	
	public void printAllComponents(int ind) {
		for (MyElements e: this) {
			if (e.isComposited()) {
				System.out.print(e.getName()+ " -> ");
				for (int i: ((MyComposite) e).getComponents())
					System.out.print(this.get(i).getName() + " ");
				System.out.println();
			}		
		}
		System.out.println(ind);
	}
	
}
