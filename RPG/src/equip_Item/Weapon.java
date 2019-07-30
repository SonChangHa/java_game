package equip_Item;

import character.Player;
import skill.SwordSkill;

public class Weapon extends Equip_item {

	public int ad;
	public int criticalRate;
	public SwordSkill swordSkill;
	public static Player player;

	public Weapon(String name, int pay, int ad, int criticalRate, SwordSkill swordSkill) {
		super(name, pay);
		this.ad = ad;
		this.criticalRate = criticalRate;
		this.swordSkill = swordSkill; 
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
		
		player.swordSkill = weapon.swordSkill;
		System.out.println(weapon.name + "을 장착하였습니다.");

	}


}
