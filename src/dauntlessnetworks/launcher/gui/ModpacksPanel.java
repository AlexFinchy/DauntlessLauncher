package dauntlessnetworks.launcher.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import dauntlessnetworks.launcher.startup.LoginInformation;
import dauntlessnetworks.launcher.startup.Startup;
import sun.reflect.annotation.TypeAnnotation.LocationInfo;

public class ModpacksPanel extends JPanel implements ModpackSelectedListener {
	
	BufferedImage BackgroundTest;
	
	ModPackSelection ModPackSelection = new ModPackSelection();
	
	ModPack CurrentModpack;
	
	RoundRectangle2D Textbox = new RoundRectangle2D.Double(100, 200, 350, 250, 15, 15);
	
	JTextArea ModPackDescription = new JTextArea();
	
	Image DauntlessLogo;
	
	ArrayList<Image> ModpackImages;
	
	//g2d.fillRoundRect(590, 500, 150, 50, 50, 50);
	//g2d.fillRoundRect(770, 500, 100, 50, 50, 50);
	
	public ModpacksPanel(LoginInformation loginInformation, ArrayList<ModPack> Modpacks, ArrayList<Image> ModpackImages) {
		setBorder(BorderFactory.createMatteBorder(Startup.BorderThinkness, 0, Startup.BorderThinkness, Startup.BorderThinkness, java.awt.Color.black));
		this.ModpackImages = ModpackImages;
		setOpaque(false);
		setLocation(100,0);
		setSize(900,600);
		setLayout(null);
		this.DauntlessLogo = ModpackImages.get(0);
		add(ModPackSelection);
		ModPackSelection.addModpackSelectedListener(this);
		for(ModPack modPack : Modpacks) {
			ModPackSelection.addModpack(modPack);
		}
		
		
		
		JPanel AvatarPanel = new JPanel();
		
		
		AvatarPanel.setLayout(null);
		
		AvatarPanel.setLocation(110,500);
		AvatarPanel.setSize(300,80);
		AvatarPanel.setBackground(new Color(60, 60, 60, 50));
		AvatarPanel.setOpaque(true);
		
		JLabel PlayerHead = new JLabel(loginInformation.getAvatar());
		PlayerHead.setText("Welcome " + loginInformation.getUsername());
		PlayerHead.setHorizontalAlignment(SwingConstants.CENTER);
		PlayerHead.setForeground(Color.white);
		PlayerHead.setLocation(0, 0);
		PlayerHead.setSize(300,50);
		PlayerHead.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		
		JLabel Logout = new JLabel("Logout");
		Logout.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		Logout.setForeground(Color.WHITE);
		Logout.setHorizontalAlignment(SwingConstants.CENTER);
		Logout.setLocation(0,30);
		Logout.setSize(65,50);
		
		Logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				System.exit(1);
				
			}
		});
		

		

		
		AvatarPanel.add(Logout);
		
		AvatarPanel.add(PlayerHead);
		
		add(AvatarPanel);
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	

			    
		
		

		
		
		ModPackDescription.setBounds(110, 210, 330, 230);
		ModPackDescription.setBackground(null);
		ModPackDescription.setOpaque(false);
		ModPackDescription.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		ModPackDescription.setForeground(Color.WHITE);
		ModPackDescription.setLineWrap(true);
		ModPackDescription.setWrapStyleWord(true);
		ModPackDescription.setEditable(false);
		ModPackDescription.setHighlighter(null);
		
		add(ModPackDescription);
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		
		
			
 		if(CurrentModpack != null) {
 			

 			
 			g.drawImage(CurrentModpack.BackgroundImage, 0, 0, 900, 600, null);
 			
 			g.drawImage(CurrentModpack.LargeLogo, 75, 15, null);
 			
 			g.setColor(new Color(40, 40, 40, 130));
 			
 			g2d.fill(Textbox);
 			
 			g.setColor(new Color(90, 90, 90, 240));
 			

 			//g2d.drawImage(ModpackImages.get(2), 560, 500, null);
 			
 			g2d.drawImage(ModpackImages.get(1), 750, 500, null);
 			
 			
 			
 			g.drawImage(DauntlessLogo, 470, 0, null);
 			
 		} else {
 			
 			//Display Generic stuff
 			
 		}
		

		//TODO MAKE IT SO IMAGES ARE BLURED IN THE STARTUP BEFORE NOW :)
		//Color SelectedColor = new Color(67, 66, 66);
		//g.setColor(SelectedColor);
		//g.fillRect(0, 0, 75, 600);
 		
		super.paint(g);
		
		
		
	}

	@Override
	public void ModPackSelectionChanged() {
		CurrentModpack = ModPackSelection.SelectedModpack;
		ModPackDescription.setText(CurrentModpack.ModPackDescription);
		repaint();
		
	}

}
