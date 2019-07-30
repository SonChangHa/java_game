package use_item;

import character.Player;

public class Use_item {

	public String name;
	public int many;
	public int pay;
	public static Player player;

	public Use_item(String name, int pay) {
		this.name = name;
		this.pay = pay;
	}

}
