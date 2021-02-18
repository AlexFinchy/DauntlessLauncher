package dauntlessnetworks.launcher.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ModPack {

	String ModPackName;
	
	String ModPackUrl;
	
	ImageIcon IconLogo;
	
	Image LargeLogo;
	
	Image BackgroundImage;
	
	String ModPackDescription;
	
	public ModPack(String ModPackName, String ModPackUrl, ImageIcon IconLogo, Image LargeLogo, Image BackgroundImage, String ModPackDescription) {
		this.ModPackName = ModPackName;
		this.ModPackUrl = ModPackUrl;
		this.IconLogo = IconLogo;
		this.LargeLogo = LargeLogo;
		this.BackgroundImage = BackgroundImage;
		this.ModPackDescription = ModPackDescription;
		
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof ModPack) {
			ModPack Modpack = (ModPack) obj;
			if(Modpack.ModPackName.equalsIgnoreCase(ModPackName)) {
				return true;
			} else {
				return false;
			}
			
			
		}
		return false;
		
	}
	
}
