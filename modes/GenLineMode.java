package modes;

import java.awt.Point;
import object.*;

public class GenLineMode {
	
	private GenLineMode() {}
	
	public static void press(Point clickPoint, MyObjects Objects) {

		MyElements e = Objects.getToppestClickedElement(clickPoint);
		
		if (e != null) {
			
			Objects.createTempLine(new MyGenLine(clickPoint, e));		
			Objects.getLines().add(Objects.getTempLine());
		} else {
			Objects.createTempLine(null);
		}
	}
	
	public static void drag(Point clickPoint, Point dragPoint, MyObjects Objects) {
		
		if (Objects.getTempLine() != null)
			Objects.getTempLine().setEndPoint(dragPoint);
		
	}
	
	public static void release(Point clickPoint, Point releasePoint, MyObjects Objects) {
		
		MyElements EndElement = Objects.getToppestClickedElement(releasePoint);
		
		if (Objects.getTempLine() != null && EndElement != null && Objects.getTempLine().getStartElement() != EndElement) {		
			Objects.getTempLine().setEnd(releasePoint, Objects.getToppestClickedElement(releasePoint));			
		} else {
			Objects.getLines().remove(Objects.getTempLine());
			Objects.clearTempLine();
		}
	}
}
