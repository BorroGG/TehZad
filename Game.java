import java.awt.Graphics;


public class Game {
private static int heroPlay = 0;

static int getheroPlay(){
	return heroPlay;
}



  void startgame(int nachGame){
	 
	 if(nachGame==1){
		 
		
		 heroPlay = 1;
	 }
	 else if(nachGame==-1){
		 
		 heroPlay = -1;
	 } 
}
 public void drawCastleWindow(Graphics gr){
		 
 }
}

 class hero {
	int hp;
	int damage;
	int attak_speed;
	int armor;
	int range_attak;
	static int gold;
	
	public static int getGold(){
		return gold;
	}
	public static int payGold(){
		gold = gold - 20;
		return gold;
	}
}
class voin extends hero {
	int sword;
	void heal(){
		hp+=50;
	}
	void createVoisko(int[] KolVoisk){
		 KolVoisk[0] = 10;
		 KolVoisk[1] = 5;
	}
}
class strelok extends hero {
	int bow;
	void buff(){
		damage+=10;
	}
	void createVoisko(int[] KolVoisk){
		 KolVoisk[0] = 5;
		 KolVoisk[1] = 10;
	}
}