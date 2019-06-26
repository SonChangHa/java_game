package character;

import java.util.Scanner;

import map.MyMap;

public class NPC extends Character {

	public int NPCtype; //1이면 상인 2이면 일반NPC 
	public static Player player;

	public NPC(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca, String art,
			int NPCtype) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.NPCtype = NPCtype;
		this.nowhp = hp;
		this.nowmp = mp;
	}

	public void NPC_battle_att() {

		System.out.println(this.name + "의 공격!!");

		this.damage = this.ad - player.dp; // 데미지는 공격력 - 방어력

		// 플레이어의 방어력이 높으면 데미지 1
		if (this.ad <= player.dp) {
			this.damage = 1;
			player.nowhp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // 크리티컬

		battle_Avoid(); // 회피

		player.nowhp -= this.damage; // 남은 HP는 HP 빼기 데미지로
		System.out.println("-" + this.damage + "!!!");
	}
	
	public void metStore(NPC npc) {
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
	}
	
	
	
	
	
	
	
	
	
	
	
}
