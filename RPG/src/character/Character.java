package character;

import java.util.Random;

public class Character {

	String name;
	public int hp; // �����ʿ�?
	public int mp;
	public int ad; // ���ݷ�
	public int dp; // ����
	public int criticalRate; // ũȮ
	public int avd; // ȸ����
	public int damage; // ����
	// public String loca[][];//�ʿ����� ��ǥ �� 2�����迭�� ����� �ȵ�.
	public int xLoca;
	public int yLoca;// ���� x, y ��ǥ
	public String art;
	
	public int nowhp; 
	public int nowmp;

	Random rand = new Random();

	int ran;

	public Character(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		this.name = name;
		this.hp = hp;// �뷱�� ���� �����
		this.mp = mp;
		this.ad = ad;
		this.dp = dp;
		this.criticalRate = criticalRate;
		this.avd = avd;
		this.xLoca = xLoca;
		this.yLoca = yLoca;
		this.art = art;
		this.nowhp = hp; 
		this.nowmp = mp;
	}

	// ũ��Ƽ�� ���� �޼ҵ�
	public void battle_critical() {

		ran = rand.nextInt(99) + 1;

		if (ran <= criticalRate) { // 1~100���� ������ �޾Ƽ� ũ��Ƽ�� Ȯ������ ũ�� �״�� �ƴϸ� 2�� == Ȯ��
			this.damage *= 2;
			System.out.println("ũ��Ƽ��!!");
		}
	}

	// ȸ�� ���� �޼ҵ�
	public void battle_Avoid() {

		ran = rand.nextInt(99) + 1;

		if (ran <= avd) { // 1~100���� ������ �޾Ƽ� ũ��Ƽ�� Ȯ������ ũ�� �״�� �ƴϸ� 2�� == Ȯ��
			this.damage = 0;
			System.out.println("���� ������!");
			return;
		}

	}

}
