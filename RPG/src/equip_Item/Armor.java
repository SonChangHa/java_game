package equip_Item;

import character.Player;

public class Armor extends Equip_item {

	public int hp;
	public int dp;
	public int avd;


	public Armor(String name, int hp, int dp, int avd) {
		super(name);
		this.hp = hp;
		this.dp = dp;
		this.avd = avd;
	}

	public static void armor_equip(Armor armor) {
		for (int a = 0; a < 50; a++)
			System.out.println();

		player.hp -= player.armor.hp;
		player.dp -= player.armor.dp;
		player.avd -= player.armor.avd;

		System.out.println(player.armor.name + "을 해제하였습니다.");

		player.armor_inventory.add(player.armor);

		player.armor = null;

		player.armor_inventory.remove(armor);

		player.hp += armor.hp;
		player.dp += armor.dp;
		player.avd += armor.avd;
		player.armor = armor;
		System.out.println(armor.name + "을 장착하였습니다.");

	}
}