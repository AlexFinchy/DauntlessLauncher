package dauntlessnetworks.launcher.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class MenuSidePanel extends JPanel implements MouseListener {

	ArrayList<Image> Images;
	
	Rectangle2D ModpacksButton = new Rectangle2D.Double(0, 339, 100, 261);
	
	Rectangle2D NewsButton = new Rectangle2D.Double(0, 181, 100, 151);
	
	Rectangle2D DonateButton = new Rectangle2D.Double(0, 0, 100, 188);
	
	Rectangle2D SelectedButton = NewsButton;
	
	
	public MenuSidePanel(ArrayList<Image> Images) {
		this.Images = Images;
		setLocation(0, 0);
		setSize(100,600);
		setBackground(new Color(90, 87, 90));
		this.addMouseListener(this);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
	
		
		
		if(SelectedButton == ModpacksButton) {
			g.drawImage(Images.get(1), 0, 339, null);
		} else {
			g.drawImage(Images.get(0), 0, 339, null);
		}
		if(SelectedButton == NewsButton) {
			g.drawImage(Images.get(3), 0, 188, null);
		} else {
			g.drawImage(Images.get(2), 0, 188, null);
		}
		if(SelectedButton == DonateButton) {
			g.drawImage(Images.get(5), 0, 0, null);
		} else {
			g.drawImage(Images.get(4), 0, 0, null);
		}
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(ModpacksButton.contains(e.getPoint())) {
			SelectedButton = ModpacksButton;
			DauntlessGUI DauntlessGUI = (DauntlessGUI) SwingUtilities.getWindowAncestor(this);
			DauntlessGUI.SwitchModpack();
		} else if(NewsButton.contains(e.getPoint())) {
			SelectedButton = NewsButton;
			DauntlessGUI DauntlessGUI = (DauntlessGUI) SwingUtilities.getWindowAncestor(this);
			DauntlessGUI.SwitchNews();
		} else if(DonateButton.contains(e.getPoint())) {
			SelectedButton = DonateButton;
			DauntlessGUI DauntlessGUI = (DauntlessGUI) SwingUtilities.getWindowAncestor(this);
			DauntlessGUI.SwitchDonate();
		}
		revalidate();
		repaint();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
