package character;

import map.MyMap;

public class Monster extends Character {

	public static Player player;
	public MyMap map;
	
	public int dropExp;
	public int dropGold;

	public Monster(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art, int dropExp, int dropGold) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
		this.dropExp = dropExp;
		this.dropGold = dropGold;
	}

	// ���Ͱ� �÷��̾ ����
	public void monster_battle_att() {

		System.out.println(this.name + "�� ����!!");

		this.damage = this.ad - player.dp; // �������� ���ݷ� - ����

		// �÷��̾��� ������ ������ ������ 1
		if (this.ad <= player.dp) {
			this.damage = 1;
			player.nowhp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // ũ��Ƽ��

		battle_Avoid(); // ȸ��

		player.nowhp -= this.damage; // ���� HP�� HP ���� ��������
		System.out.println("-" + this.damage + "!!!");
	}

}
