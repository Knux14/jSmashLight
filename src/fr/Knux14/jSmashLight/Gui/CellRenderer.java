package fr.Knux14.jSmashLight.Gui;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class CellRenderer implements ListCellRenderer<JPanel> {

	@Override
	public Component getListCellRendererComponent(JList<? extends JPanel> list,
			JPanel value, int index, boolean isSelected, boolean cellHasFocus) {
		value.repaint();
		return value;
	}

}
