package character;

import map.MyMap;
import java.util.*;
import equip_Item.*;

public class Player extends Character {

	public NPC npc;

	public Weapon weapon;
	public Armor armor;
	public MyMap nowmap;

	public ArrayList<Equip_item> armor_inventory;// 장비아이템
	// static ArrayList<Use_item> Use_inventory;

	public Player(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
	}

	public void show_inventory() {

	}

	// 상대와 조우하였을때 전투 시작
	public void monster_encounter(Monster monster) {

		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 20; a++)
			System.out.println();

		System.out.println(monster.name + "과 만났습니다!");

		while (true) {
			System.out.println("공격 : 1, 스킬 : 2, 아이템 : 3, 도주 : 4");
			System.out.println("어떤 행동을 하시겠습니까?");
			input = scan.nextInt();
			if (input == 1)
				this.player_battle_att();// 플레이어는 동작이 다르지만 몬스터는 공격만 함.
			if (monster.hp <= 0) {
				// 몬스터 죽었음.
				System.out.println("몬스터를 물리쳤습니다.");
				nowmap.map[monster.yLoca][monster.xLoca] = this.art;
				monster = null;
				return;
			}
			monster.monster_battle_att();
			if (this.hp <= 0) {
				// 플레이어 죽었음. 게임오버
				System.out.println("플레이어의 체력이 0이 되었습니다.");
				System.out.println("게임오버");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "의 남은 체력은 " + this.hp);
			System.out.println(monster.name + "의 남은 체력은 " + monster.hp);

			for (int a = 0; a < 20; a++)
				System.out.println();
		}
	}

	public void npc_encounter() {

		// 조건을 넣어야함. 막 싸울순 없자나

		for (int a = 0; a < 20; a++)
			System.out.println();

		System.out.println(npc.name + "와 전투시작!");

		while (this.hp >= 0 || npc.hp >= 0) {
			player_battle_att();
			NPC.NPC_battle_att();// NPC가 때리는건 왜 안넣었냐.
		}
	}

	public void player_battle_att() {

		System.out.println(this.name + "의 공격!");

		this.damage = this.ad - monster.dp; // 데미지는 공격력 - 방어력

		if (this.ad <= monster.dp) { // 방어력이 높으면 뎀지 1
			this.damage = 1;
			monster.hp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // 크리

		battle_Avoid(); // 회피

		monster.hp -= this.damage; // 남은 HP는 HP 빼기 데미지로
		System.out.println("-" + this.damage + "!!!");
	}

}
