package equip_Item;

import character.Player;

public class Armor extends Equip_item {

	int hp;
	int dp;
	int avd;

	Player player;

	public Armor(String name, int weight, int durability, int hp, int dp, int avd) {
		super(name, weight, durability);
		this.hp = hp;
		this.dp = dp;
		this.avd = avd;
	}

	public void Armor_equip(Armor armor) {

		if (player.armor != null)
			Armor_remove();

		player.armor_inventory.remove(armor);

		player.hp += armor.hp;
		player.dp += armor.dp;
		player.avd += armor.avd;
		player.armor = armor;
		System.out.println(armor.name + "�� �����Ͽ����ϴ�.");

	}

	public void Armor_remove() {

		player.hp -= player.armor.hp;
		player.dp -= player.armor.dp;
		player.avd -= player.armor.avd;

		System.out.println(player.armor.name + "�� �����Ͽ����ϴ�.");

		player.armor_inventory.add(player.armor);

		player.armor = null;
	}

}