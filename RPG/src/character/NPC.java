package character;

import java.util.Scanner;

import map.MyMap;

public class NPC extends Character {

	public static Player player;

	public NPC(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca, String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
	}
	
/*	public void metStore(NPC npc) {
		System.out.println("어서와!");
		System.out.println("물건을 구매하고싶으면 1, 아니면 아무 숫자나 눌러줘!");
		Scanner scan = new Scanner(System.in);
		int input;
		input = scan.nextInt();
		if(input == 1) {
			//물건 목록 보여줌
	
		}
		else
			return;
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
