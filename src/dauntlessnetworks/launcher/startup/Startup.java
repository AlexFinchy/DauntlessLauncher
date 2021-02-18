package dauntlessnetworks.launcher.startup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import dauntlessnetworks.launcher.gui.DauntlessGUI;
import dauntlessnetworks.launcher.gui.MenuSidePanel;
import dauntlessnetworks.launcher.gui.ModPack;

public class Startup {

	public static void main(String[] args) {
		new Startup();
	}
	
	public static final int BlurRadius = 2; //Zero means no blur
	public static final int BorderThinkness = 2;
	
	public Startup() {
		
		
		LogoPanel logoPanel = null;
		
		LoginPanel loginPanel = null;
		
		JFrame Logo = new JFrame();
		
		Image DauntlessIcon = null;
		
		ArrayList<Image> ModPackImages = new ArrayList<>();
		
		BufferedImage DauntlessLogoModpackBuff = null;
		
		Logo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<Image> SidePanelImages = new ArrayList<>();
		//Load Buttons
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		ArrayList<ModPack> Modpacks = new ArrayList<>();
		
		try {
			
			//Modpack Logos and stuff
			
			DauntlessIcon = ImageIO.read(classLoader.getResourceAsStream("DauntlessIcon.png"));
			
			Logo.setIconImage(DauntlessIcon);
			
			Image DauntlessLogo = ImageIO.read(classLoader.getResourceAsStream("DauntlessLogo.png"));
			
			DauntlessLogo = DauntlessLogo.getScaledInstance(360, 360, Image.SCALE_SMOOTH);
			
			Logo.setUndecorated(true);
			
			Logo.setBackground(new Color(0, 0, 0,0));
			
			Logo.setSize(360, 380);
			
			logoPanel = new LogoPanel(DauntlessLogo);
			
			Logo.add(logoPanel);
			
			Logo.setLocationRelativeTo(null);
			
			Logo.setVisible(true);
			
			
			Image DauntlessLogoModpack = ImageIO.read(classLoader.getResourceAsStream("DauntlessLogo.png"));
			
			DauntlessLogoModpack = DauntlessLogoModpack.getScaledInstance(425, 425, Image.SCALE_SMOOTH);
			
			
			DauntlessLogoModpackBuff = new BufferedImage(425, 425, BufferedImage.TYPE_INT_ARGB);
			
			DauntlessLogoModpackBuff.getGraphics().drawImage(DauntlessLogoModpack, 0, 0, null);
			
			Image PlayButton = ImageIO.read(classLoader.getResource("PlayButton.png"));
			Image UnistallButton = ImageIO.read(classLoader.getResource("UnistallButton.png"));
			
			
			ModPackImages.add(DauntlessLogoModpack);
			ModPackImages.add(PlayButton);
			ModPackImages.add(UnistallButton);
			
			//Image AtomFalloutLogo = ImageIO.read(classLoader.getResourceAsStream("AtomfalloutLogo.png"));
			//Image AtomFalloutIcon = ImageIO.read(classLoader.getResourceAsStream("AtomFalloutIcon.png"));
			//Image AtomFalloutBackground = ImageIO.read(classLoader.getResourceAsStream("AtomFalloutBackground.jpg"));
			
			//ModPack AtomFallout = new ModPack("Atom Fallout","http://storage.pandaserv.net:8000/f/316be355157a4732afde/?dl=1",new ImageIcon(AtomFalloutIcon), AtomFalloutLogo, BlurImage((BufferedImage) AtomFalloutBackground), "This modpack is based on Fallout, it contains many mods that help to make the game challenging but also fun. Play with your friends on our offical server or go alone on single player" );
			
			//Modpacks.add(AtomFallout);
			logoPanel.bar.setValue(logoPanel.bar.getValue() + 5);
			Image WizardryEvolvedLogo = ImageIO.read(classLoader.getResourceAsStream("WizardryEvolvedLogo.png"));
			Image WizardryEvolvedIcon = ImageIO.read(classLoader.getResourceAsStream("WizardryEvolvedIcon.png"));
			Image WizardryEvolvedBackground = ImageIO.read(classLoader.getResourceAsStream("WizardryEvolvedBackground.jpg"));
			
			ModPack WizardryEvolvedFallout = new ModPack("Wizardry Evolved","",new ImageIcon(WizardryEvolvedIcon), WizardryEvolvedLogo, BlurImage((BufferedImage) WizardryEvolvedBackground), "Mystic Arts " );
			
			Modpacks.add(WizardryEvolvedFallout);
			
			
			
			logoPanel.bar.setValue(5);
			
			

			
			
			ArrayList<Image> LoginImages = new ArrayList<>();
			
			Image DauntlessBanner = ImageIO.read(classLoader.getResourceAsStream("DauntlessLauncher.png"));
			Image LoginButton = ImageIO.read(classLoader.getResourceAsStream("LoginButton.png"));
			Image LoginButtonMouseOver = ImageIO.read(classLoader.getResourceAsStream("LoginButtonMouseOver.png"));
			Image LoginCross = ImageIO.read(classLoader.getResourceAsStream("LoginClose.png"));
			Image LoginCrossMouseOver = ImageIO.read(classLoader.getResourceAsStream("LoginCrossMouseOver.png"));
			ImageIcon LoadingGif = new ImageIcon(classLoader.getResource("LoadingGif.gif"));
			logoPanel.bar.setValue(logoPanel.bar.getValue() + 5);
			
			
			LoginImages.add(DauntlessBanner);
			LoginImages.add(LoginButton);
			LoginImages.add(LoginButtonMouseOver);
			LoginImages.add(LoginCross);
			LoginImages.add(LoginCrossMouseOver);
			loginPanel = new LoginPanel(LoginImages,LoadingGif);
			logoPanel.bar.setValue(logoPanel.bar.getValue() + 5);
			
			Image PackButton = ImageIO.read(classLoader.getResourceAsStream("PacksButton.png"));
			Image PackButtonSelected = ImageIO.read(classLoader.getResourceAsStream("PacksButtonSelected.png"));
			
			Image NewsButton = ImageIO.read(classLoader.getResourceAsStream("NewsButton.png"));
			Image NewsButtonSelected = ImageIO.read(classLoader.getResourceAsStream("NewsButtonSelected.png"));
			
			Image DonateButton = ImageIO.read(classLoader.getResourceAsStream("DonateButton.png"));
			Image DonateButtonSelected = ImageIO.read(classLoader.getResourceAsStream("DonateButtonSelected.png"));
			
			logoPanel.bar.setValue(75);
			
			SidePanelImages.add(PackButton);
			SidePanelImages.add(PackButtonSelected);
			SidePanelImages.add(NewsButton);
			SidePanelImages.add(NewsButtonSelected);
			SidePanelImages.add(DonateButton);
			SidePanelImages.add(DonateButtonSelected);
			logoPanel.bar.setValue(logoPanel.bar.getValue() + 5);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Load stuff first then display login dialog
		
		logoPanel.bar.setValue(100);
		
		Logo.dispose();

		
		
		JFrame LoginFrame = new JFrame();

		LoginFrame.setSize(350,400);
		LoginFrame.setIconImage(DauntlessIcon);
		LoginFrame.setLocationRelativeTo(null);
		LoginFrame.setUndecorated(true);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.add(loginPanel);
		LoginFrame.setVisible(true);
		LoginInformation loginInformation = loginPanel.GetLoginInformation();
		LoginFrame.dispose();
		
		
		
		//LoginInformation loginInformation = new LoginInformation("Offline", "UUID", "Token");
		System.out.println("Got login info");
		
		DauntlessGUI dauntlessGUI = new DauntlessGUI(loginInformation,Modpacks, ModPackImages);
		dauntlessGUI.setIconImage(DauntlessIcon);
		MenuSidePanel MenuSide = new MenuSidePanel(SidePanelImages);
		dauntlessGUI.add(MenuSide);
		dauntlessGUI.setVisible(true);
		
	}
	
	public Image BlurImage(BufferedImage Image) {
		
		Image ScaledImage =  Image.getScaledInstance(900, 600, java.awt.Image.SCALE_SMOOTH);
		
		BufferedImage ScaledImageBuff = new BufferedImage(900, 600, BufferedImage.TYPE_INT_ARGB);
		Graphics graphics1 = ScaledImageBuff.getGraphics();
		
		graphics1.drawImage(ScaledImage, 0, 0, null);
		graphics1.dispose();
		
		
		int radius = BlurRadius;
		int size = radius * 2 + 1;
		float weight = 1.0f / (size * size);
		float[] data = new float[size * size];

		for (int i = 0; i < data.length; i++) {
		    data[i] = weight;
		}
		
		Kernel kernel = new Kernel(size, size, data);
		ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_ZERO_FILL, null);
		//tbi is BufferedImage
		BufferedImage EndImage  = op.filter(ScaledImageBuff, null);
		
		EndImage = EndImage.getSubimage(BlurRadius, BlurRadius, 900-BlurRadius, 600-BlurRadius);
		
		Image FinalImage = EndImage.getScaledInstance(900, 600, java.awt.Image.SCALE_SMOOTH);
		
		return FinalImage;
		
		
	}
	
}
