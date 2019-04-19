package main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import object.*;

public class MenuBarPanel extends JMenuBar {
	
	private static MyArrayList elements;
	private Gui fr;
	
	public MenuBarPanel(Gui MainFrame, ArrayList<MyElements> ElementList) {
		
		fr = MainFrame;
		elements = (MyArrayList) ElementList;
		
	    JMenu FileMenu = new JMenu("File");
	    JMenu EditMenu = new JMenu("Edit");
	    
	    JMenuItem MenuItemGroup = new JMenuItem("Group");
	    JMenuItem MenuItemUngroup = new JMenuItem("Ungroup");
	    JMenuItem MenuItemChangeName = new JMenuItem("Change object name");
	    
	    EditMenu.add(MenuItemGroup);
	    EditMenu.add(MenuItemUngroup);
	    EditMenu.add(MenuItemChangeName);
	    
	    add(FileMenu);
	    add(EditMenu);
	    
		MenuItemGroup.addActionListener(e -> {
			doGroup(); 
			fr.getDrawPanel().repaint();
        });
		
		MenuItemUngroup.addActionListener(e -> {
			doUngroup();
			fr.getDrawPanel().repaint();
        });
		
		MenuItemChangeName.addActionListener(e -> {
        	doChangeName();
        	fr.getDrawPanel().repaint();
        });
		

	}
	
	public void doGroup() {	
		if (elements.getSelectedAmount() > 1) {
			elements.add(new MyComposite(elements));
		} 
	}
	
	public void doUngroup() {
		if (elements.getSelectedAmount() == 1) {
			int Index = elements.getFirstSelectedIndex();
			if (elements.get(Index).isComposited()) {			
				((MyComposite) elements.get(Index)).getComponents().forEach(e -> {
					if (!elements.get(e).Groupedby.isEmpty())
						elements.get(e).Groupedby.remove(elements.get(e).Groupedby.size()-1);					
				});
				elements.remove(Index);
				elements.trimToSize();
			}				
		}
			
	}
	
	public void doChangeName() {
    	int SelectedIndex = 0;
    	
		if (elements.getSelectedAmount() == 1) {
			SelectedIndex = elements.getFirstSelectedIndex();    			
			String NewName = JOptionPane.showInputDialog("Enter New Object Name"); 
			elements.get(SelectedIndex).setName(NewName);
		}
	}

}
