import javax.swing.JFrame;

public class Launcher {


	
	public static JFrame world;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		world = new Fenetre();
		IA IA = new IA();
		Player Player = new Player();
		IAcharacter IAcharacter = new IAcharacter();
		Battle Battle = new Battle();
		
	}

}
