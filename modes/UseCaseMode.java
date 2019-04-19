package modes;

import java.awt.Point;
import java.util.ArrayList;

import object.*;

public class UseCaseMode {
	private UseCaseMode() {}
	
	public static void click(Point clickPoint, ArrayList<MyElements> elements) {
		elements.add(new MyUseCase(clickPoint, elements.size()));		
	}
}
