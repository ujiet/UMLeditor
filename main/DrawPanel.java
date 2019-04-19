package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import object.*;


@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	
	private Gui fr;
	private MyObjects Objects;
	
	public DrawPanel(Gui MainFrame, MyObjects obj) {
		fr = MainFrame;
		setBackground(Color.white);
		Objects = obj;
		
		MouseAdapter ma = new MouseAdapter() {
			private Point clickPoint;
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clickPoint = e.getPoint();				
				MouseEvents.click(fr.getCurrentMode(), clickPoint, Objects);
				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				clickPoint = e.getPoint();
				MouseEvents.press(fr.getCurrentMode(), clickPoint, Objects);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Point dragPoint = e.getPoint();
				MouseEvents.drag(fr.getCurrentMode(), clickPoint, dragPoint, Objects);
				repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				MouseEvents.release(fr.getCurrentMode(), Objects);
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
		Objects.getSelectionRect().update(g);
		
		/* basic objects */
		for (MyElements e: Objects.getElements()) {
			e.update(g);
		}
		
		/* connection lines */		
		for (MyLines e: Objects.getLines()) {
			e.update(g);
		}
	}
}

