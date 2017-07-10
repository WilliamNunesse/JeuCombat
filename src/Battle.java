// Here is is time for the battle to begin !
import java.util.Scanner;

public class Battle{
	

	public static StringBuffer BotDraw = new StringBuffer();
	public static StringBuffer PlayerDraw = new StringBuffer(); //This is going to be useful when drawing our characters based on their previous attack
	
	public Battle(){
		
		boolean block = false;
		
		int HPplayer = Player.playerHP;
		int APplayer = Player.playerAP;
		
		int playeridentity = Player.characterchoice;
		
		int HPbot = IAcharacter.IAHP;
		int APbot = IAcharacter.IAAP;
		
	
		PlayerDraw.append("/Image/");
		BotDraw.append("/Image/");
		
		Scanner nextchoice = new Scanner(System.in);
		
		int nextmove = 0;
		
		while(HPplayer > 0 && HPbot > 0 ){ //Condition to know if the battle is still going or if one of the two characters is dead
			System.out.println("What is your next move ? :\n1-->Attack\n2-->Block\n3-->Special Attack");
			int botdecision = IAcharacter.IAprocessing(playeridentity, HPplayer, HPbot); //Here the bot is choosing what it is about to do
			//System.out.println(botdecision);
			while (nextmove != 1 && nextmove != 2 && nextmove != 3){
				nextmove = nextchoice.nextInt(); //Here we let the player decide what he is about to do 
				if (nextmove == 1){
					HPbot = Character.attack(APplayer, HPbot, false);
					System.out.println("You did "+APplayer+"dmgs");
					if(playeridentity == 1){
						PlayerDraw.insert(7, "HealerAttack.png");
					}
					if(playeridentity == 2){
						PlayerDraw.insert(7, "DamagerAttack.png");
					}
					if(playeridentity == 3){
						PlayerDraw.insert(7, "TankAttack.png");
					}
				}
				if (nextmove == 2){
					block = Character.block(); //Here we set block on true meaning for the next dmgs he can only take 1 maximum
					if(playeridentity == 1){
						PlayerDraw.insert(7, "HealerBlock.png");
					}
					if(playeridentity == 2){
						PlayerDraw.insert(7, "DamagerBlock.png");
					}
					if(playeridentity == 3){
						PlayerDraw.insert(7, "TankBlock.png");
					}
				}
				if(nextmove == 3){
					if(playeridentity == 1){
						HPplayer = Healer.specialattack(HPbot);
						PlayerDraw.insert(7, "HealerSpecial.png");
					}
					if(playeridentity == 2){
						int[] HP = Damager.specialattack(HPplayer, HPbot);
						HPplayer = HP[0];
						HPbot = HP[1];
						PlayerDraw.insert(7, "DamagerSpecial.png");
					}
					if(playeridentity == 3){
						int[] HP = Tank.specialattack(HPplayer, HPbot);
						HPplayer = HP[0];
						HPbot = HP[1];
						PlayerDraw.insert(7, "DamagerSpecial.png");
					}
				}
				if (nextmove != 1 && nextmove != 2 && nextmove != 3){ //This is a security so if the user enters say "4" the system will ask him again and again until he chooses 1;2 or 3 (but if you want to bug it just enter anything else than an int)
					System.out.println("Please type 1; 2 or 3 to select your next move");
				}
			}
			if (botdecision == 1){
				HPplayer = Character.attack(APbot, HPplayer, block);
				if(IAcharacter.IAcharacterchoice == 1){
					BotDraw.insert(7, "HealerAttack.png");
				}
				if(IAcharacter.IAcharacterchoice == 2){
					BotDraw.insert(7, "DamagerAttack.png");
				}
				if(IAcharacter.IAcharacterchoice == 3){
					BotDraw.insert(7, "TankAttack.png");
				}
			}
			if (botdecision == 2){
				if(IAcharacter.IAcharacterchoice == 1){
					HPbot = Healer.specialattack(HPbot);
					BotDraw.insert(7, "HealerSpecial.png");
				}
				if(IAcharacter.IAcharacterchoice == 2){
					int[] HP = Damager.specialattack(HPbot, HPplayer);
					HPbot = HP[0];
					HPplayer = HP[1];
					BotDraw.insert(7, "DamagerSpecial.png");
				}
				if(IAcharacter.IAcharacterchoice == 3){
					int[] HP = Tank.specialattack(HPbot, HPplayer);
					HPbot = HP[0];
					HPplayer = HP[1];
					BotDraw.insert(7, "TankSpecial.png");
				}
			}
			nextmove = 0;
			block = false;
			System.out.println("You still have : "+HPplayer+"HP left\nYour nemesis still has : "+HPbot+"HP");
		}
		if(HPplayer>0 && HPbot<=0){
			System.out.println("You Win !");
		}
		if(HPplayer<=0 && HPbot>0){
			System.out.println("You Loose...");
		}
		if(HPplayer<=0 && HPbot<=0){
			System.out.println("Equality ..!");
		}
		try {
			Thread.sleep(5000); //Here for 5 secondes we freeze the program so that the user can read what is written
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0); // And here we exit the program
	}

}
