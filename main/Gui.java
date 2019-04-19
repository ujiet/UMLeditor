package main;

import java.awt.*;
import javax.swing.*;

import object.MyObjects;

public class Gui {
	private static final int WIDTH = 960;
	private static final int HEIGHT = 640;
	private static String CurrentMode;
	private static DrawPanel drawPanel;
	private static ButtonPanel buttonPanel;
	private MyObjects Objects;
	
	Gui() {
		JFrame fr = new JFrame("UML editor");
		Objects = new MyObjects();
		
		fr.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		fr.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		fr.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);

        fr.setJMenuBar(new MenuBarPanel(this, Objects));    
		fr.setLayout(new BorderLayout());
		
		drawPanel = new DrawPanel(this, Objects);
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
