package character;

import map.MyMap;

public class Monster extends Character {

	public static Player player;
	public MyMap map;

	public Monster(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
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
