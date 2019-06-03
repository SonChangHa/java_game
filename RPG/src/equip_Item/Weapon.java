package equip_Item;

import character.Player;

public class Weapon extends Equip_item {

	int ad;
	int criticalRate;

	Player player;

	public Weapon(String name, int weight, int durability, int ad, int criticalRate, Player player_m) {
		super(name, weight, durability);
		this.ad = ad;
		this.criticalRate = criticalRate;
		player = player_m;
	}

	public void Weapon_add() {

		player.ad = this.ad + player.ad;
		player.dp = this.criticalRate + player.criticalRate;
		System.out.println("아이템을 장착하였습니다.");
	}

}
