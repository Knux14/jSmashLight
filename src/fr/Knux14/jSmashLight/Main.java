package fr.Knux14.jSmashLight;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public class Main {

	public static FileConfiguration config;
	public static int levelUnlocked;
	public static Font font;
	public static BufferedImage button_1, button_2, button_3;
	public static BufferedImage backgrd, logo;
	public static BufferedImage case_1, case_2, case_3;
	public static String gamemode;
	public static int size = 2;
	
	public static void main(String args[]) {
		try {
			File f = new File("config.ini");
			if (!f.exists()) f.createNewFile();
			config = new PropertiesConfiguration("config.ini");
			config.setAutoSave(true);
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			gamemode = config.getString("gamemode", "click");
			config.save();
			loadPict();
			new GameFrame();
		} catch (ConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void loadPict(){
		try {
			font = Font.createFont(0, Main.class.getResourceAsStream("res/xolonium.ttf"));
			backgrd = ImageIO.read(Main.class.getResourceAsStream("res/fond.png"));		
			logo = ImageIO.read(Main.class.getResourceAsStream("res/logo.png"));		
			button_1 = ImageIO.read(Main.class.getResourceAsStream("res/button_normal.png"));
			button_2 = ImageIO.read(Main.class.getResourceAsStream("res/button_surlined.png"));
			button_3 = ImageIO.read(Main.class.getResourceAsStream("res/button_clic.png"));
			case_1 = ImageIO.read(Main.class.getResourceAsStream("res/image0.png"));
			case_2 = ImageIO.read(Main.class.getResourceAsStream("res/image1.png"));
			case_3 = ImageIO.read(Main.class.getResourceAsStream("res/image2.png"));
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
	}
}
