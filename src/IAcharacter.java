
public class IAcharacter {
	
	static int IAHP; //Healthpoints
	static int IAAP;//Attackpoints
	static int IAcharacterchoice;//The character the IA chose
	
	public IAcharacter()	{
			if (IA.IAlvl == 1){
				if (Player.characterchoice == 1) { //The easy bot will choose the same class as you did 
					System.out.println("The bot chose 'the Healer'");
					IAHP = Healer.getHealthPoint();
					IAAP = Healer.getAttackPoint();
					IAcharacterchoice = 1;
					}
				if (Player.characterchoice == 2) {
					System.out.println("The bot chose 'the Damager'");
					IAHP = Damager.getHealthPoint();
					IAAP = Damager.getAttackPoint();
					IAcharacterchoice = 2;
					}
				if(Player.characterchoice == 3) {
					System.out.println("The bot chose 'the Tank'");
					IAHP = Tank.getHealthPoint();
					IAAP = Tank.getAttackPoint();
					IAcharacterchoice = 3;
				}
			}
			if (IA.IAlvl == 2){
				if (Player.characterchoice == 1) { //The hard bot always takes the better class against yours
					System.out.println("The bot chose 'the Damager'");
					IAHP = Damager.getHealthPoint();
					IAAP = Damager.getAttackPoint();
					IAcharacterchoice = 2;
					}
				if (Player.characterchoice == 2) {
					System.out.println("The bot chose 'the Tank'");
					IAHP = Tank.getHealthPoint();
					IAAP = Tank.getAttackPoint();
					IAcharacterchoice = 3;
					}
				if(Player.characterchoice == 3) {
					System.out.println("The bot chose 'the Healer'");
					IAHP = Healer.getHealthPoint();
					IAAP = Healer.getAttackPoint();
					IAcharacterchoice = 1;
				}	
			}
		System.out.println("The bot now have "+IAHP+" HealthPoint or 'HP' and "+IAAP+" AttackPoint or 'AP'");
	}
	static int IAprocessing(int playeridentity, int HPplayer, int HPbot){ // Since it is pretty much useless to block I decided that the bot will never use this ability
		int decision = 0;
		if(IA.IAlvl == 1){
			double A = Math.random()+1;
			decision = (int) Math.round(A);
		}
		if(IA.IAlvl == 2){
			if(playeridentity == 1){
				decision = 1;
			}
			if(playeridentity == 2){
				if(HPplayer == 3){
					decision = 2;
				}
				if(HPplayer == 2){
					decision = 2;
				}
				if(HPplayer == 1){
					decision = 1;
				}
			}
			if(playeridentity == 3){
				if(HPbot >= 3){
					decision = 1;
				}
				if(HPbot < 3){
					decision = 2;
				}
			}
		}
		return decision;
		
	}

}
