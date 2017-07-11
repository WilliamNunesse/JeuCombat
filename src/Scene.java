import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial") 

public class Scene extends JPanel{
	
	public static Scene scene;
	
	private ImageIcon icoBackImage;
	private Image imgBackImage;
	
	private ImageIcon icoPlayerImage;
	private Image imgPlayerImage;
	
	private ImageIcon icoBotImage;
	private Image imgBotImage;
	
	private final int BACK_IMAGE_WIDTH = 1280;
	
	static String RoadToPlayerImage = "";
	static String RoadToBotImage = "";
	
	public Scene(){
		
		
		super();
		String RoadToBackImage = "/Images/BackImage.png  ";
		
		this.icoBackImage = new ImageIcon(getClass().getResource(RoadToBackImage));
		this.imgBackImage = this.icoBackImage.getImage();

		this.icoPlayerImage = new ImageIcon(getClass().getResource(RoadToPlayerImage));
		this.imgPlayerImage = this.icoPlayerImage.getImage();
		
		this.icoBotImage = new ImageIcon(getClass().getResource(RoadToBotImage));
		this.imgBotImage = this.icoBotImage.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		Thread TimerEcran = new Thread (new Timer());
		TimerEcran.start();
		
	}
	public void paintComponent(Graphics g){
		g.drawImage(this.imgBackImage, 0, 0, null);
		g.drawImage(this.imgPlayerImage, -500, -500, null);
		g.drawImage(this.imgBotImage, 500, 500, null);
	}
	public static void setRoadToPlayerImage(String NewRoad){
		RoadToPlayerImage = NewRoad;
	}
	public static void setRoadToBotImage(String NewRoad){
		RoadToBotImage = NewRoad;
	}
}
