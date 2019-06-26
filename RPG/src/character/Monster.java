package character;

import map.MyMap;

public class Monster extends Character {

	public static Player player;
	public MyMap map;

	public Monster(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
	}

	// 몬스터가 플레이어를 공격
	public void monster_battle_att() {

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

}
