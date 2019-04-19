package modes;

import java.awt.Point;
import object.*;

public class GenLineMode {
	private GenLineMode() {}
	
	public static void press(Point clickPoint, MyObjects Objects) {

		MyElements e = Objects.getToppestClickedElement(clickPoint);
		
		if (e != null) {
		
			if (e.clickInUpRight(clickPoint) && e.clickInDownRight(clickPoint))  // right
				Objects.setTempLineStartPoint(e.getRightPoint());
			if (!e.clickInUpRight(clickPoint) && e.clickInDownRight(clickPoint))  // down
				Objects.setTempLineStartPoint(e.getDownPoint());
			if (!e.clickInUpRight(clickPoint) && !e.clickInDownRight(clickPoint))  // left
				Objects.setTempLineStartPoint(e.getLeftPoint());
			if (e.clickInUpRight(clickPoint) && !e.clickInDownRight(clickPoint))  // up
				Objects.setTempLineStartPoint(e.getUpPoint());
			
			System.out.println("StartPoint -> " + Objects.getTempLine().getStartPoint());
		} 		
	}
	
	public static void drag(Point clickPoint, Point dragPoint, MyObjects Objects) {
		
	}
	
	public static void release(MyObjects Objects) {
		
	}
}
