package use_item;

public class Portion extends Use_item {

	public int healHp;
	public int healMp;
	public int many;

	public Portion(String name, int many, int healHp, int healMp) {
		super(name);
		this.many = many;
		this.healHp = healHp;
		this.healMp = healMp;
	}
	
	public static void use_portion(Portion portion) {
		if(portion.healHp != 0) {
			int heal = portion.healHp;
			if(portion.healHp + player.nowhp > player.hp)
				heal = player.hp - player.nowhp;
			player.nowhp += heal;
			
			System.out.println("체력이 +" + heal + "만큼 회복되었습니다.");
			System.out.println("현재 체력은 " + player.nowhp + "/" + player.hp +"입니다.");
		}
		
		if(portion.healMp != 0) {
			int heal = portion.healMp;
			if(portion.healMp + player.nowmp > player.mp)
				heal = player.mp - player.nowmp;
			player.nowmp += heal;
			System.out.println("마나가 +" + heal + "만큼 회복되었습니다.");
			System.out.println("현재 마나는 " + player.nowmp + "/" + player.mp +"입니다.");
		}
		
		portion.many--;
		
		if(portion.many == 0)
			player.portion_inventory.remove(portion);
			
		
	}

	
}
