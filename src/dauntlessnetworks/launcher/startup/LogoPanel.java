package dauntlessnetworks.launcher.startup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class LogoPanel extends JPanel{
	
	JProgressBar bar = new JProgressBar();
	
	Image Logo;
	
	public LogoPanel(Image Logo) {
		setLayout(null);
		this.Logo = Logo;
		setOpaque(false);
		
		bar.setBounds(10,350,350,20);
		add(bar);
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Logo, 0, 0, null);
		
	}
	
	
	

}
