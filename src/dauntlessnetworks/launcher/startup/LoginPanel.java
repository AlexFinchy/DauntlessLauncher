package dauntlessnetworks.launcher.startup;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.json.JSONObject;


import dauntlessnetworks.launcher.gui.DauntlessGUI;
import sun.security.util.Password;

public class LoginPanel extends JPanel implements MouseMotionListener {
	
	//LoginFrame.setSize(350,400);
	
	private volatile int screenX = 0;
	private volatile int screenY = 0;
	private volatile int myX = 0;
	private volatile int myY = 0;
	
	ArrayList<Image> Images;
	
	java.awt.geom.RoundRectangle2D LoginButton = new java.awt.geom.RoundRectangle2D.Double(240, 335, 79, 36, 25, 25);
	
	java.awt.geom.RoundRectangle2D CloseButton = new java.awt.geom.RoundRectangle2D.Double(325, 2, 22, 24, 5, 5);
	
	Boolean MouseOverLogin = false;
	
	Boolean MouseOverClose = false;
	
	volatile Boolean Loading = false;
	
	Image LoadingGif;
	
	JLabel LoadingGifPanel = new JLabel();
	
	volatile Boolean LoginSuccess = false;
	
	LoginInformation loginInformation;
	
	public LoginPanel(ArrayList<Image> Images, ImageIcon LoadingGif) {
		addMouseMotionListener(this);
		setLayout(null);
		setOpaque(false);
		this.Images = Images;
		
		JLabel Disclaimer = new JLabel("Dauntless Launcher 2018");
		Disclaimer.setForeground(Color.white);
		Disclaimer.setBounds(25, 380, 200, 10);
		add(Disclaimer);
		
		LoadingGifPanel.setIcon(LoadingGif);
		LoadingGifPanel.setSize(200,100);
		LoadingGifPanel.setLocation(25,305);
		add(LoadingGifPanel);
		LoadingGifPanel.setVisible(false);
		

		
		
		JLabel UsernameLabel = new JLabel("Mojang Account Email:");
		
		JLabel PasswordLabel = new JLabel("Password:");
		
		UsernameLabel.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		PasswordLabel.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		
		UsernameLabel.setBounds(25,110,300,55);
		PasswordLabel.setBounds(25,190, 300, 55);
		
		UsernameLabel.setForeground(Color.WHITE);
		PasswordLabel.setForeground(Color.white);
		
		add(UsernameLabel);
		add(PasswordLabel);
		
		
		JTextField Username = new JTextField();
		JPasswordField Password = new JPasswordField();
		
		Username.setCaretColor(Color.WHITE);
		Password.setCaretColor(Color.WHITE);
		
		Username.setBounds(25,140,300,55);
		Password.setBounds(25,220, 300, 55);
		
		Username.setBorder(null);
		Password.setBorder(null);
		
		Username.setBackground(null);
		Password.setBackground(null);
		
		Username.setOpaque(false);
		Password.setOpaque(false);
		
		Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray));
		Password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray));
		
		Username.setForeground(Color.WHITE);
		
		Password.setForeground(Color.WHITE);
		
		Username.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				Username.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.WHITE));
			}
		});
		
		Password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray));
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				Password.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.white));
				
			}
		});
		
		
		Username.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		Password.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
		
		
		add(Username);
		add(Password);
		
		JCheckBox box = new JCheckBox("Remember me?");
		box.setLocation(222, 360);
		box.setSize(120,50);
		box.setOpaque(false);
		box.setBackground(null);
		box.setForeground(Color.WHITE);
		box.setBorder(null);
		
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Code for Remember me
				//TODO
			}
		});
		
		add(box);
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				if(LoginButton.contains(e.getPoint())) {
					//Authenticate
					Authenticater authenticater = new Authenticater(Username.getText(), String.valueOf(Password.getPassword()));
					try {
						JSONObject Response = authenticater.Authenticate();
						if(Response.has("errorMessage")) {
							String error = Response.getString("errorMessage");
							JOptionPane.showMessageDialog(null, error, "Failed to Login", JOptionPane.ERROR_MESSAGE);
						} else {
							//Login
							
							JSONObject UserProfile = Response.getJSONObject("selectedProfile");
							
							String UUID = UserProfile.getString("id");
							
							String Username = UserProfile.getString("name");
							
							String AccessToken = Response.getString("accessToken");
							
							ImageIcon PlayerIcon;

							PlayerIcon = new ImageIcon(ImageIO.read(new URL("https://crafatar.com/avatars/" + UUID + "?size=32&helm")));
							JLabel PlayerHead = new JLabel(PlayerIcon);
							PlayerHead.setText("Welcome " + Username);
							PlayerHead.setHorizontalAlignment(SwingConstants.LEFT);
							PlayerHead.setForeground(Color.white);
							PlayerHead.setLocation(25, 290);
							PlayerHead.setSize(300,50);
							PlayerHead.setFont(new Font("trebuchet MS", Font.PLAIN, 20));
							add(PlayerHead);
							repaint();
							revalidate();
							Thread thread = new Thread(new Runnable() {
								
								@Override
								public void run() {
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									loginInformation = new LoginInformation(Username, UUID, AccessToken, PlayerIcon);
									LoginSuccess = true;
								}
							});
							
							thread.start();
							
							
							
							
							//Do some login code here lol
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if(CloseButton.contains(e.getPoint())) {
					System.exit(1);
				} else {
			        screenX = e.getXOnScreen();
			        screenY = e.getYOnScreen();

			        myX = SwingUtilities.getWindowAncestor(LoginPanel.this).getX();
			        myY = SwingUtilities.getWindowAncestor(LoginPanel.this).getY();
				}
				
			}
			
		});
	}
	
	public LoginInformation GetLoginInformation() {
		
		while(!LoginSuccess);
		return loginInformation;
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D graphics2d = (Graphics2D) g;
		
		g.setColor(new Color(51, 51, 51));
		
		//g.fillRect(0, 0, 350, 50);
		g.drawImage(Images.get(0), 0, 0, null);
		
		g.fillRect(0, 100, 350, 400);
		
		g.setColor(Color.red);
		
		if(MouseOverLogin) {
			g.drawImage(Images.get(2), 230, 320, null);
		} else {
			g.drawImage(Images.get(1), 230, 320, null);
		}
		
		if(MouseOverClose) {
			g.drawImage(Images.get(4), 300, 0, null);
		} else {
			g.drawImage(Images.get(3), 300, 0, null);
		}
		

		
		super.paint(g);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        SwingUtilities.getWindowAncestor(this).setLocation(myX + deltaX, myY + deltaY);
        
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(LoginButton.contains((e.getPoint()))) {
			MouseOverLogin = true;
		} else {
			MouseOverLogin = false;
		}
		
		if(CloseButton.contains(e.getPoint())) {
			MouseOverClose = true;
		} else {
			MouseOverClose = false;
		}
		
		repaint();
	}

}
