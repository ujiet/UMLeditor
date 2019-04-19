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
		} 		
	}
	
	public static void drag(Point clickPoint, Point dragPoint, MyObjects Objects) {
		
		Objects.getTempLine().setEndPoint(dragPoint);
		
	}
	
	public static void release(Point clickPoint, Point releasePoint, MyObjects Objects) {
		
		Objects.getTempLine().setEnd(releasePoint, Objects.getToppestClickedElement(releasePoint));
		
		MyElements StartElement = Objects.getTempLine().getStartElement();
		MyElements EndElement = Objects.getTempLine().getEndElement();
		
		if (Objects.getTempLine() != null && StartElement != null && StartElement != EndElement) {
			Objects.clearTempLine();
		} else {
			Objects.getLines().remove(Objects.getTempLine());
		}
		
		System.out.println("Objects.Lines -> " + Objects.getLines().toString());
	}
}
