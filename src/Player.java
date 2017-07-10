import java.util.Scanner;

public class Player {
	
	static int characterchoice = 0;
	
	static int playerHP;
	static int playerAP;
	
	Scanner lvlchoice = new Scanner(System.in);
	public Player()	{
		System.out.println("Please choose a character\n1-->the Healer\n2-->the Damager\n3-->the Tank");
		while (characterchoice != 1 && characterchoice != 2 && characterchoice != 3){
			characterchoice = lvlchoice.nextInt();
			if (characterchoice == 1){
				System.out.println("You chose 'the Healer'");
				playerHP = Healer.getHealthPoint();
				playerAP = Healer.getAttackPoint();
			}
			if (characterchoice == 2){
				System.out.println("You chose 'the Damager'");
				playerHP = Damager.getHealthPoint();
				playerAP = Damager.getAttackPoint();
			}
			if(characterchoice == 3) {
				System.out.println("You chose 'the Tank'");
				playerHP = Tank.getHealthPoint();
				playerAP = Tank.getAttackPoint();
			}
			if (characterchoice != 1 && characterchoice != 2 && characterchoice != 3){
				System.out.println("Please type 1; 2 or 3 to select a character");
			}
		}
		System.out.println("You now have "+playerHP+" HealthPoint or 'HP' and "+playerAP+" AttackPoint or 'AP'");
	}
	public static int getPlayerHP() {
		return playerHP;
	}
	public static int getPlayerAP() {
		return playerAP;
	}
	public static int getPlayerClass() {
		return characterchoice;
	}
}
