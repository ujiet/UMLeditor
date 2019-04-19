package modes;

import java.awt.Point;
import java.util.ArrayList;
import object.*;

import object.MyElements;

public class GenLineMode {
	private GenLineMode() {}
	
	public static void press(Point clickPoint, ArrayList<MyElements> elements) {

		MyElements e = ((MyArrayList) elements).getToppestClickedObject(clickPoint);
		
		if (e != null) {				
		
			if (e.clickInUpRight(clickPoint) && e.clickInDownRight(clickPoint))  // right
				
			if (!e.clickInUpRight(clickPoint) && e.clickInDownRight(clickPoint))  // down
				System.out.println("Click in -down- of " + e.getName());
			if (!e.clickInUpRight(clickPoint) && !e.clickInDownRight(clickPoint))  // left
				System.out.println("Click in -left- of " + e.getName());
			if (e.clickInUpRight(clickPoint) && !e.clickInDownRight(clickPoint))  // up
				System.out.println("Click in -up- of " + e.getName());
							
		} 		
	}
	
	public static void drag(Point clickPoint, Point dragPoint, ArrayList<MyElements> elements) {
		
	}
	
	public static void release(ArrayList<MyElements> elements) {
		
	}
}
