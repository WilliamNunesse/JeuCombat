import javax.swing.JFrame;


@SuppressWarnings({ "serial" })
public class Fenetre extends JFrame{
	
	public static Scene scene;
	
	public Fenetre(){
		
		scene = new Scene();
		
		this.setTitle("BoulderDash 2 !");
		this.setSize(1280,720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		
		this.setContentPane(scene);
		this.setVisible(true);
		
	}

}
