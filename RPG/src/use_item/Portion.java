package use_item;

public class Portion extends Use_item {

	int hp;
	int mp;

	public Portion(String name, int weight, int durability, int hp, int mp) {
		super(name, weight, durability);
		this.hp = hp;
		this.mp = mp;
	}

}
