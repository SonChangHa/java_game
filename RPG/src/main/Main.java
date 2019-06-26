package main;

import character.*;
import java.util.Scanner;
import equip_Item.*;
import map.*;
import script.Script;
import skill.*;
import use_item.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String move;
		int select = 0;
		
		// �÷��̾� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���
		Player player = new Player("����", 100, 100, 30, 10, 0, 0, 1, 1, "+");
		// �÷��̾�� �ٲ��� �ʴ� ���̴ϱ� ����ƽ �����ص���
		Monster.player = player;
		MyMap.player = player;
		Equip_item.player = player;
		Use_item.player = player;
		Skill.player = player;
		Script.player = player;
		
		Script script = new Script();


		// �� ��ü ����(�̸�, hp, dp, avd)
		// ���Զ� �������� ���ô�
		Armor noarmor = new Armor("�Ǹ�", 0, 0, 0);
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		
		
		// ���� ��ü ����(�̸�, ad, cri)
		Weapon noweapon = new Weapon("�Ǽ�", 1, 1);

		
		
		// ���� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���)
		Monster slime = new Monster("������", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		
		
		//NPC ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���, Ÿ��)
		//Ÿ���� 1�̸� ���� 2�̸� �Ϲ�
		NPC elder = new NPC("����", 10, 10, 1, 1, 1, 1, 7, 7, "!", 2);
		

		// ���� ��ü ����(�̸�, ����, ȸ��ü��, ȸ������)
		Portion redPortion = new Portion("���� ����", 10, 15, 10);

		// ȸ����ų ��ü ����(�̸�, �Ҹ� ����, ȸ�� ü��%, ��ų ����)
		Heal smallHeal = new Heal("�ϱ� ȸ��", 5, 10, "ü���� ���� ȸ���Ѵ�.");

		//��ų�� ��ü ����(�̸�, ��ų)
		SkillBook lowhealbook = new SkillBook("�ϱ�ȸ�� å", smallHeal);

		// �� ��ü ����(new String[y����][x����], �̸�, ��Ż1 x��ǥ, y��ǥ, ��Ż2 x, ��Ż2 y, ��Ż1 �����, 2 �����, �� 1,2,3,4,5)
		Twopotal town = new Twopotal(new String[10][20], "����", 6, 6, 8, 8, null, null);
		Onepotal home = new Onepotal(new String[10][10], "����Ȩ", 5, 1, town);
		Onepotal nothing = new Onepotal(new String[3][3], "�̵��� ��", 1, 1, town);
		Onepotal pond = new Onepotal(new String[10][15], "����", 5, 1, town);
		
		
		town.potalnext1 = home;
		town.potalnext2 = nothing;
		
		town.npc1 = elder;
		
		pond.monster1 = slime;
		
		
		
		
		
		
		
		//���ʸ� ����
		player.nowmap = home;
		
		//���� �� ����
		player.armor_inventory.add(noarmor);
		player.armor = noarmor;
		//���� ���� ����
		player.weapon_inventory.add(noweapon);
		player.weapon = noweapon;
		
		
		
		
		
		
		// ������� ���� ����

		script.game_start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//{��Ż�̶� �÷��̾� ǥ������
		player.nowmap.map[player.nowmap.potalyLoca1][player.nowmap.potalxLoca1] = "@";
		player.nowmap.map[player.yLoca][player.xLoca] = player.art;
		//}��������� ���� �ѹ��� ���ָ��
		player.nowmap.map_print();
		
		
	
		
		
		
		while (true) {
				
			if(player.nowmap == town)
				town.potalnext2 = nothing;
			
			if(player.nowmap == nothing) {
				System.out.println("�̵��ϰ� ���� ������ �Է����ּ���.");
				select = scan.nextInt();
				
			if(select == 1) {
				town.potalnext2 = pond;
				player.nowmap = pond;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
				
			}
			
			
			//���
			
			//�� ������ �� �������� ��簡 ��µ��� �ʰ���
			if(player.nowmap != home)
				script.home_start_cheak = false;
			
			//���������� ���
			if(script.home_start_cheak == true)
				script.home_start();
			
			//��θ����� ��������� ���
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elder_start_cheak == true) {
				script.elder_start();
				script.elder_start_cheak = false;
				elder.art = "*";
			}
			
			System.out.println("�̵��Ϸ��� wasd, �޴��� ���÷��� 1�� �Է����ּ���.");
			move = scan.next();//�ڹ� ������ ��¥ Line���� ���๮�� �ӽñⶫ�� �ȵǰ� �� �ؽ�Ʈ ����
			// string�� || ���� ���� �񱳰� �ȵ�. �׷��� ���� �޼ҵ带 ����ؾ���.
			if (move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d"))
				player.nowmap.map_all(move);
			 else {
				player.show_menu();
				player.nowmap.map_print();
			 }
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// ���θ޼ҵ�

}
