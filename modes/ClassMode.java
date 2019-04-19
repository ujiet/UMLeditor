package modes;

import java.awt.Point;
import java.util.ArrayList;

import object.MyClass;
import object.MyElements;

public class ClassMode {
	private ClassMode() {}
	
	public static void click(Point clickPoint, ArrayList<MyElements> elements) {
		elements.add(new MyClass(clickPoint, elements.size()));		
	}
}
