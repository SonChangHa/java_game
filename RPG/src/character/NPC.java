package character;

import java.util.Scanner;

import map.MyMap;

public class NPC extends Character {

	public int NPCtype; //1�̸� ���� 2�̸� �Ϲ�NPC 
	public static Player player;

	public NPC(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca, String art,
			int NPCtype) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.NPCtype = NPCtype;
		this.nowhp = hp;
		this.nowmp = mp;
	}

	public void NPC_battle_att() {

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
	
	public void metStore(NPC npc) {
		System.out.println("���!");
		System.out.println("������ �����ϰ������ 1, �ƴϸ� �ƹ� ���ڳ� ������!");
		Scanner scan = new Scanner(System.in);
		int input;
		input = scan.nextInt();
		if(input == 1) {
			//���� ��� ������
	
		}
		else
			return;
	}
	
	
	
	
	
	
	
	
	
	
	
}
