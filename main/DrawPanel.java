package main;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import modes.*;
import object.*;

import java.util.ArrayList;

public class DrawPanel extends JPanel {
	
	private Gui fr;
	private ArrayList<MyElements> elements;
	
	public DrawPanel(Gui MainFrame, ArrayList<MyElements> ElementList) {
		fr = MainFrame;
		setBackground(Color.white);
		elements = ElementList;	
		
		MouseAdapter ma = new MouseAdapter() {
			private Point clickPoint;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clickPoint = e.getPoint();				
				MouseEvents.click(fr.getCurrentMode(), clickPoint, elements);
				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				clickPoint = e.getPoint();
				MouseEvents.press(fr.getCurrentMode(), clickPoint, elements);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Point dragPoint = e.getPoint();
				MouseEvents.drag(fr.getCurrentMode(), clickPoint, dragPoint, elements);
				repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				MouseEvents.release(fr.getCurrentMode(), elements);
				repaint();
			}
		};

		addMouseListener(ma);
		addMouseMotionListener(ma);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/* selection rectangle */
		((MyArrayList) elements).getSelectionRect().update(g);
		
		/* basic objects */
		for (MyElements e: elements) {
			e.update(g);
		}
		
		/* connection lines */
	}
}

