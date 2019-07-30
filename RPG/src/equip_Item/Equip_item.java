package equip_Item;

import character.Player;

public class Equip_item {

	public static Player player;
	
	public String name;
	public int pay;
//	public int weight;
	//public int durability;

	public Equip_item(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}
	
}
