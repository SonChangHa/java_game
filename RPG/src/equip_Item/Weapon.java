package equip_Item;

import character.Player;

public class Weapon extends Equip_item {

	public int ad;
	public int criticalRate;

	public Weapon(String name, int ad, int criticalRate) {
		super(name);
		this.ad = ad;
		this.criticalRate = criticalRate;
	}

	public static void weapon_equip(Weapon weapon) {
		
		for (int a = 0; a < 50; a++)
			System.out.println();
		
		player.ad += player.weapon.ad;
		player.criticalRate += player.weapon.criticalRate;
		
		System.out.println(player.weapon.name + "을 해제하였습니다.");

		player.weapon_inventory.add(player.weapon);

		player.weapon = null;

		player.weapon_inventory.remove(weapon);

		player.ad += weapon.ad;
		player.criticalRate += weapon.criticalRate;
		player.weapon = weapon;
		System.out.println(weapon.name + "을 장착하였습니다.");

	}


}
