package dauntlessnetworks.launcher.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import dauntlessnetworks.launcher.startup.Startup;

public class NewsPanel extends JPanel{

	public NewsPanel() {
		setOpaque(false);
		setLocation(100,0);
		setSize(900,600);
		setLayout(null);
		setBorder(BorderFactory.createMatteBorder(Startup.BorderThinkness, 0, Startup.BorderThinkness, Startup.BorderThinkness, java.awt.Color.black));
		setBackground(Color.WHITE);
	}
	
	
}
