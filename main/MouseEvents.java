package main;

import java.awt.Point;

import java.util.ArrayList;
import modes.*;
import object.*;

public class MouseEvents {
	private MouseEvents() {}
	
	public static void click(String CurrentMode, Point clickPoint, ArrayList<MyElements> elements) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.clickSelect(clickPoint, elements);
				break;
			case "Class": 
				ClassMode.click(clickPoint, elements);				
				break;
			case "UseCase":
				UseCaseMode.click(clickPoint, elements);
				break;
			default:
				break;
		}
	}
	
	public static void press(String CurrentMode, Point clickPoint, ArrayList<MyElements> elements) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.pressMove(clickPoint, elements);
				SelectMode.pressSelect(clickPoint, elements);
				break;
			case "GenLine":
				GenLineMode.press(clickPoint, elements);
				break;
			default:
				break;
		}
	}
	
	public static void drag(String CurrentMode, Point clickPoint, Point dragPoint, ArrayList<MyElements> elements) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.dragMove(clickPoint, dragPoint, elements);
				SelectMode.dragSelect(clickPoint, dragPoint, elements);
				break;
			case "GenLine":
				GenLineMode.drag(clickPoint, dragPoint, elements);
				break;
			default:
				break;
		}
	}
	
	public static void release(String CurrentMode, ArrayList<MyElements> elements) {
		
		switch (CurrentMode) {
			case "Select":
				SelectMode.releaseMove(elements);
				SelectMode.releaseSelect(elements);
				break;
			case "GenLine":
				GenLineMode.release(elements);
				break;
			default:
				break;
		}
	}
}
