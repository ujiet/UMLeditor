package main;

import java.awt.Point;
import modes.*;
import object.*;

public class MouseEvents {
	private MouseEvents() {}
	
	public static void click(String CurrentMode, Point clickPoint, MyObjects Objects) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.clickSelect(clickPoint, Objects);
				break;
			case "Class": 
				ClassMode.click(clickPoint, Objects);				
				break;
			case "UseCase":
				UseCaseMode.click(clickPoint, Objects);
				break;
			default:
				break;
		}
	}
	
	public static void press(String CurrentMode, Point clickPoint, MyObjects Objects) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.pressMove(clickPoint, Objects);
				SelectMode.pressSelect(clickPoint, Objects);
				break;
			case "GenLine":
				GenLineMode.press(clickPoint, Objects);
				break;
			default:
				break;
		}
	}
	
	public static void drag(String CurrentMode, Point clickPoint, Point dragPoint, MyObjects Objects) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.dragMove(clickPoint, dragPoint, Objects);
				SelectMode.dragSelect(clickPoint, dragPoint, Objects);
				break;
			case "GenLine":
				GenLineMode.drag(clickPoint, dragPoint, Objects);
				break;
			default:
				break;
		}
	}
	
	public static void release(String CurrentMode, MyObjects Objects) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.releaseMove(Objects);
				SelectMode.releaseSelect(Objects);
				break;
			case "GenLine":
				GenLineMode.release(Objects);
				break;
			default:
				break;
		}
	}
}
