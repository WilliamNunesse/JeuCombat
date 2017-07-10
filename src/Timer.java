
public class Timer implements Runnable{
	
	private final int PAUSE = 10; //Time in milliseconds before refreshing our panel
	
	public void run(){
		
		while (true){
			
			Scene.scene.repaint();
			//System.out.println("Timer is good !");
			
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e){}
		}
	}
}