package character;

import map.MyMap;
import java.util.*;
import equip_Item.*;

public class Player extends Character {

	public NPC npc;

	public Weapon weapon;
	public Armor armor;
	public MyMap nowmap;

	public ArrayList<Equip_item> armor_inventory;// ��������
	// static ArrayList<Use_item> Use_inventory;

	public Player(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
	}

	public void show_inventory() {

	}

	// ���� �����Ͽ����� ���� ����
	public void monster_encounter(Monster monster) {

		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 20; a++)
			System.out.println();

		System.out.println(monster.name + "�� �������ϴ�!");

		while (true) {
			System.out.println("���� : 1, ��ų : 2, ������ : 3, ���� : 4");
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?");
			input = scan.nextInt();
			if (input == 1)
				this.player_battle_att();// �÷��̾�� ������ �ٸ����� ���ʹ� ���ݸ� ��.
			if (monster.hp <= 0) {
				// ���� �׾���.
				System.out.println("���͸� �����ƽ��ϴ�.");
				nowmap.map[monster.yLoca][monster.xLoca] = this.art;
				monster = null;
				return;
			}
			monster.monster_battle_att();
			if (this.hp <= 0) {
				// �÷��̾� �׾���. ���ӿ���
				System.out.println("�÷��̾��� ü���� 0�� �Ǿ����ϴ�.");
				System.out.println("���ӿ���");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "�� ���� ü���� " + this.hp);
			System.out.println(monster.name + "�� ���� ü���� " + monster.hp);

			for (int a = 0; a < 20; a++)
				System.out.println();
		}
	}

	public void npc_encounter() {

		// ������ �־����. �� �ο�� ���ڳ�

		for (int a = 0; a < 20; a++)
			System.out.println();

		System.out.println(npc.name + "�� ��������!");

		while (this.hp >= 0 || npc.hp >= 0) {
			player_battle_att();
			NPC.NPC_battle_att();// NPC�� �����°� �� �ȳ־���.
		}
	}

	public void player_battle_att() {

		System.out.println(this.name + "�� ����!");

		this.damage = this.ad - monster.dp; // �������� ���ݷ� - ����

		if (this.ad <= monster.dp) { // ������ ������ ���� 1
			this.damage = 1;
			monster.hp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // ũ��

		battle_Avoid(); // ȸ��

		monster.hp -= this.damage; // ���� HP�� HP ���� ��������
		System.out.println("-" + this.damage + "!!!");
	}

}
