package modes;

import java.awt.Point;
import object.MyClass;
import object.MyObjects;

public class ClassMode {
	private ClassMode() {}
	
	public static void click(Point clickPoint, MyObjects Objects) {
		Objects.getElements().add(new MyClass(clickPoint, Objects.getElements().size()));		
	}
}
