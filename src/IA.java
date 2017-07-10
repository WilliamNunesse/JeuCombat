import java.util.Scanner; //This import is used lines : 7;11 it allows us to get a 

//Here we are going to let the player choose the bot difficulty

public class IA {
	static int IAlvl = 0;
	Scanner lvlchoice = new Scanner(System.in);
	public IA()	{
		System.out.println("Please choose a level of difficulty for the AI : 1-->easy or 2 -->hard");
		while (IAlvl != 1 && IAlvl != 2){
			IAlvl = lvlchoice.nextInt();
			if (IAlvl == 1){
				System.out.println("You chose easy mode");
			}
			if (IAlvl == 2){
				System.out.println("You chose hard mode");
			}
			if (IAlvl != 1 && IAlvl != 2){
				System.out.println("Please type 1 or 2");
			}
		}
	}
}
	
