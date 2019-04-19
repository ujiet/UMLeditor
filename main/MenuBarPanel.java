package main;

import java.util.ArrayList;
import javax.swing.*;
import object.*;

@SuppressWarnings("serial")
public class MenuBarPanel extends JMenuBar {
	
	private static MyObjects Objects;
	private Gui fr;
	
	public MenuBarPanel(Gui MainFrame, MyObjects obj) {
		
		fr = MainFrame;
		Objects = obj;
		
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
		if (Objects.getSelectedAmount() > 1) {
			Objects.getElements().add(new MyComposite(Objects.getElements()));
		} 
	}
	
	public void doUngroup() {
		if (Objects.getSelectedAmount() == 1) {
			int Index = Objects.getFirstSelectedIndex();
			ArrayList<MyElements> elements = Objects.getElements();
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
    	
		if (Objects.getSelectedAmount() == 1) {
			SelectedIndex = Objects.getFirstSelectedIndex();    			
			String NewName = JOptionPane.showInputDialog("Enter New Object Name"); 
			Objects.getElements().get(SelectedIndex).setName(NewName);
		}
	}

}
