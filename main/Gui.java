package main;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import object.MyArrayList;
import object.MyElements;

public class Gui {
	private static final int WIDTH = 960;
	private static final int HEIGHT = 640;
	private static String CurrentMode;
	private static DrawPanel drawPanel;
	private static ButtonPanel buttonPanel;
	public static ArrayList<MyElements> elements;
	
	Gui() {
		JFrame fr = new JFrame("UML editor");
		elements = new MyArrayList();
		
		fr.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		fr.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		fr.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);

        fr.setJMenuBar(new MenuBarPanel(this, elements));    
		fr.setLayout(new BorderLayout());
		
		drawPanel = new DrawPanel(this, elements);
		buttonPanel = new ButtonPanel(this);
		
		fr.add(buttonPanel, BorderLayout.WEST);
		fr.add(drawPanel, BorderLayout.CENTER);
		
		setCurrentMode("None");
		
		fr.setVisible(true);
	}
	
	public DrawPanel getDrawPanel() {
		return drawPanel;
	}
	
	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	
	public void setCurrentMode(String s) {
		CurrentMode = s;
	}
	
	public String getCurrentMode() {
		return CurrentMode;
	}
}
