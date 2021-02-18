package dauntlessnetworks.launcher.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dauntlessnetworks.launcher.startup.Startup;

public class ModPackSelection extends JPanel {
	
	ModPack SelectedModpack;
	
	JPanel SelectedTab;
	
	int ModpackNumber = 0;
	
	private List<ModpackSelectedListener> Listeners = new ArrayList<ModpackSelectedListener>();
	
	public ModPackSelection() {
		setBorder(BorderFactory.createMatteBorder(Startup.BorderThinkness ,0, Startup.BorderThinkness, 0, java.awt.Color.black));
		setLayout(null);
		setLocation(0, 0);
		setSize(75, 600);
		setBackground(new Color(67, 66, 66));
	}
	
	public void addModpack(ModPack modPack) {
		
		JPanel ModpackPanel = new JPanel();
		ModpackPanel.setLayout(null);
		ModpackPanel.setSize(75,75);
		ModpackPanel.setBackground(new Color(67, 66, 66));
		ModpackPanel.setLocation(0,(75*ModpackNumber)+Startup.BorderThinkness);
		
		JLabel Icon = new JLabel(modPack.IconLogo);
		Icon.setSize(75,75);
		Icon.setVerticalAlignment(SwingConstants.CENTER);
		ModpackPanel.add(Icon);
		ModpackPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				if(SelectedTab == null) {
					SelectedTab = ModpackPanel;
					SelectedTab.setBackground(new Color(128, 128, 128));
				} else if(SelectedTab != ModpackPanel) {
					SelectedTab.setBackground(new Color(67, 66, 66));
					SelectedTab = ModpackPanel;
					SelectedTab.setBackground(new Color(128, 128, 128));
					
				}
				SelectedModpack = modPack;
				for(ModpackSelectedListener listener : Listeners) {
					listener.ModPackSelectionChanged();
				}
			}
			
		});
		ModpackNumber = ModpackNumber + 1;
		add(ModpackPanel);
		
	}

	
	public void addModpackSelectedListener(ModpackSelectedListener e) {
		Listeners.add(e);

	}
	
	
	

	
}
