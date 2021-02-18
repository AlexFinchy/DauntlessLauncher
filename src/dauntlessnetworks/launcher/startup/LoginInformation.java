package dauntlessnetworks.launcher.startup;

import javax.swing.ImageIcon;

public class LoginInformation {
	
	String Username;
	String UUID;
	String AccessToken;
	ImageIcon Avatar;
	
	public LoginInformation(String Username, String UUID, String AccessToken, ImageIcon Avatar) {
		
		this.Username = Username;
		this.UUID = UUID;
		this.AccessToken = AccessToken;
		this.Avatar = Avatar;
		
	}
	
	public LoginInformation(String Username, String UUID, String AccessToken) {
		
		this.Username = Username;
		this.UUID = UUID;
		this.AccessToken = AccessToken;
		this.Avatar = null;
		
	}
	
	public String getUsername() {
		return Username;
	}
	
	public ImageIcon getAvatar() {
		return Avatar;
	}
	
	public String getAccessToken() {
		return AccessToken;
	}
	
	public String getUUID() {
		return UUID;
	}
	//TEMP
	public void setUsername(String username) {
		Username = username;
	}
}
