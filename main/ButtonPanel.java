package main;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private Gui fr;
	
	public ButtonPanel(Gui MainFrame) {
		fr = MainFrame;
		setLayout(new GridLayout(0, 1, 5, 5));
		
		ButtonGroup group = new ButtonGroup();
		
		JToggleButton SelectButton = new JToggleButton("Select");
		group.add(SelectButton);
		add(SelectButton);
		JToggleButton AssocLineButton = new JToggleButton("AssocLine");
		group.add(AssocLineButton);
		add(AssocLineButton);
		JToggleButton GenLineButton= new JToggleButton("GenLine");
		group.add(GenLineButton);
		add(GenLineButton);
		JToggleButton CompLineButton= new JToggleButton("CompLine");
		group.add(CompLineButton);
		add(CompLineButton);
		JToggleButton ClassButton = new JToggleButton("Class");
		group.add(ClassButton);
		add(ClassButton);
		JToggleButton UseCaseButton = new JToggleButton("Use Case");
		group.add(UseCaseButton);
		add(UseCaseButton);
		
		SelectButton.addActionListener(e -> {
        	fr.setCurrentMode("Select");
        });
		
		AssocLineButton.addActionListener(e -> {
        	fr.setCurrentMode("AssocLine");
        });
		
		CompLineButton.addActionListener(e -> {
        	fr.setCurrentMode("CompLine");
        });
		
		GenLineButton.addActionListener(e -> {
        	fr.setCurrentMode("GenLine");
        });
		
        ClassButton.addActionListener(e -> {
        	fr.setCurrentMode("Class");
        });

        UseCaseButton.addActionListener(e -> {
        	fr.setCurrentMode("UseCase");
        });
		
	}
	
}
