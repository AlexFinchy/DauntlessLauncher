package dauntlessnetworks.launcher.gui;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dauntlessnetworks.launcher.startup.LoginInformation;

public class DauntlessGUI extends JFrame {
	
	ModpacksPanel modpacksPanel;
	NewsPanel newsPanel;
	//DonatePanel donatePanel;
	JPanel CurrentPanel;
	
	LoginInformation loginInformation;
	
	public DauntlessGUI(LoginInformation loginInformation, ArrayList<ModPack> Modpacks, ArrayList<Image> ModpackImages) {
		this.loginInformation = loginInformation;
		setLayout(null);
		setUndecorated(true);
		setSize(1000,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(loginInformation.getAccessToken());
		modpacksPanel = new ModpacksPanel(loginInformation, Modpacks, ModpackImages);
		newsPanel = new NewsPanel();
		//donatePanel = new DonatePanel();
		
		//Make it so it starts on NewsPanel
		CurrentPanel = newsPanel;
		add(newsPanel);

	}
	

	
	public void SwitchModpack() {
		remove(CurrentPanel);
		CurrentPanel = modpacksPanel;
		add(modpacksPanel);
		revalidate();
		repaint();
	}
	
	public void SwitchNews() {
		remove(CurrentPanel);
		CurrentPanel = newsPanel;
		add(newsPanel);
		revalidate();
		repaint();
	}
	
	public void SwitchDonate() {
		//donatePanel = new DonatePanel();
		remove(CurrentPanel);
		//CurrentPanel = donatePanel;
		//add(donatePanel);
		revalidate();
		repaint();
	}
	

}
