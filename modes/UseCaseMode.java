package modes;

import java.awt.Point;
import object.*;

public class UseCaseMode {
	private UseCaseMode() {}
	
	public static void click(Point clickPoint, MyObjects Objects) {
		Objects.getElements().add(new MyUseCase(clickPoint, Objects.getElements().size()));		
	}
}
