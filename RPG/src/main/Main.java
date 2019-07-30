package main;

import character.*;
import java.util.Scanner;

import battleThread.CastleBattleThread;
import battleThread.PorestBattleThread;
import battleThread.RockBattleThread;
import equip_Item.*;
import map.*;
import music.*;
import script.Script;
import skill.*;
import use_item.*;

public class Main extends Thread {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String move;
		int select = 0;
		
		// �÷��̾� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���
		Player player = new Player("����", 10000, 100, 200, 10, 0, 0, 1, 1, "+");
		// �÷��̾�� �ٲ��� �ʴ� ���̴ϱ� ����ƽ �����ص���
		Monster.player = player;
		MyMap.player = player;
		Equip_item.player = player;
		Use_item.player = player;
		Skill.player = player;
		Script.player = player;
		RockBattleThread.player = player;
		PorestBattleThread.player = player;
		CastleBattleThread.player = player;
		NPC.player = player;
		SwordSkill.player = player;
		Weapon.player = player;
		
		Script script = new Script();

		// ���⽺ų (�̸� �Ҹ� ������ ����)
		SwordSkill noskill = new SwordSkill("������", 10, 50, "���ذ� ������.");
		SwordSkill startskill = new SwordSkill("������ ����", 30, 100, "������ ������ �Ѵ�.");
		SwordSkill goblinskill = new SwordSkill("�ι����", 50, 150, "�ι� ���.");
		SwordSkill orkskill = new SwordSkill("�ƸӺ극��ũ", 100, 300, "���� �μ��� �����Ѵ�.");
		SwordSkill vampireskill = new SwordSkill("�ͺ�����", 300, 500, "�ͺ����� ����");

		// �� ��ü ����(�̸�, ����, hp, dp, avd)
		// ���Զ� �������� ���ô�
		Armor noarmor = new Armor("�Ǹ�", 0, 0, 0, 0);
		Armor startarmor = new Armor("���谡�� ��", 0, 100, 10, 10);
		Armor goblinarmor = new Armor("���� ����", 1000, 50, 10, 80);
		Armor orkarmor = new Armor("���弮 ����", 3000, 300, 50, 0);
		Armor vampirearmor = new Armor("���� ����", 5000, 200, 30, 50);
		
		
		// ���� ��ü ����(�̸�, ����, ad, cri, ��ų)
		Weapon noweapon = new Weapon("�Ǽ�", 0, 1, 1, noskill);
		Weapon startsword = new Weapon("������ ��", 0, 10, 10, startskill);
		Weapon goblinsword = new Weapon("��� �ܰ�", 1000, 20, 80, goblinskill);
		Weapon orksword = new Weapon("��ũ�� ���", 3000, 70, 0, orkskill);
		Weapon vampiresword = new Weapon("������", 5000, 40, 50, vampireskill);
		

		
		
		// ���� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���, ����ġ, ���)
		Monster slime1 = new Monster("������", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime2 = new Monster("������", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime3 = new Monster("������", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime4 = new Monster("������", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		
		
		//��������
		Monster rockBoss = new Monster("��������", 100, 100, 30, 5, 30, 30, 5, 1, "#", 100, 300);
		Monster porestBoss = new Monster("������", 300, 300, 30, 60, 40, 40, 13, 13, "#", 300, 500);
		Monster castleBoss = new Monster("��Ʈ������̵�", 600, 500, 100, 50, 30, 30, 18, 5, "#", 600, 100);
		
		
		
		
		//NPC ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���)
		//Ÿ���� 1�̸� ���� 2�̸� �Ϲ�
		NPC elder = new NPC("����", 10, 10, 1, 1, 1, 1, 7, 7, "!");
		NPC snow = new NPC("��ȭ", 10, 10, 1, 1, 1, 1, 4, 3, "!");
		NPC merchant = new NPC("���ξ�����", 10, 10, 1, 1, 1, 1, 2, 2, "$");
		
		NPC elf = new NPC("����", 1, 1, 1, 1, 1, 1, 5, 5, "!");
		
		merchant.npc_armor_inventory.add(goblinarmor);
		merchant.npc_armor_inventory.add(orkarmor);
		merchant.npc_armor_inventory.add(vampirearmor);
		
		merchant.npc_weapon_inventory.add(goblinsword);
		merchant.npc_weapon_inventory.add(orksword);
		merchant.npc_weapon_inventory.add(vampiresword);
		
		

		// ���� ��ü ����(�̸�, ����, ����, ȸ��ü��, ȸ������)
		Portion redPortion = new Portion("���� ����", 10, 1, 30, 0);
		Portion bluePortion = new Portion("�Ķ� ����", 10, 1, 0, 30);
		Portion allPortion = new Portion("���� ����", 30, 1, 30, 30);
		
		merchant.npc_portion_inventory.add(redPortion);
		merchant.npc_portion_inventory.add(bluePortion);
		merchant.npc_portion_inventory.add(allPortion);

		// ȸ����ų ��ü ����(�̸�, �Ҹ� ����, ȸ�� ü��%, ��ų ����)
		Heal lowHeal = new Heal("�ϱ� ȸ��", 5, 10, "ü���� ���� ȸ���Ѵ�.");
		Heal middleHeal = new Heal("�߱� ȸ��", 30, 50, "ü���� ������ ȸ���Ѵ�.");
		Heal bigHeal = new Heal("��� ȸ��", 100, 70, "ü���� ���� ȸ���Ѵ�.");

		//��ų�� ��ü ����(�̸�, ����, ��ų)
		SkillBook lowhealbook = new SkillBook("�ϱ�ȸ�� å", 50, lowHeal);
		SkillBook middlehealbook = new SkillBook("�ϱ�ȸ�� å", 3000, middleHeal);
		SkillBook bighealbook = new SkillBook("�ϱ�ȸ�� å", 5000, bigHeal);

		merchant.npc_skillBook_inventory.add(lowhealbook);
		merchant.npc_skillBook_inventory.add(middlehealbook);
		merchant.npc_skillBook_inventory.add(bighealbook);
		
		// �� ��ü ����(new String[y����][x����], �̸�, ��Ż1 x��ǥ, y��ǥ, ��Ż2 x, ��Ż2 y, ��Ż1 �����, 2 �����, �� 1,2,3,4,5)
		Twopotal town = new Twopotal(new String[10][20], "����", 6, 6, 8, 1, null, null);
		Onepotal home = new Onepotal(new String[10][10], "����Ȩ", 5, 1, town);
		Onepotal nothing = new Onepotal(new String[3][3], "�̵��� ��", 1, 1, town);
		Onepotal pond = new Onepotal(new String[10][15], "����", 5, 1, town);
		Twopotal rock1 = new Twopotal(new String[15][10], "������ 1", 5, 13, 5, 1, town, null);
		Twopotal rock2 = new Twopotal(new String[15][10], "������ 2", 5, 13, 5, 1, rock1, null);
		Onepotal rock3 = new Onepotal(new String[15][10], "������ 3", 5, 13, rock2);
		Twopotal porest1 = new Twopotal(new String[15][20], "õ�� ������ 1", 3, 1, 13, 13, town, null);
		Twopotal porest2 = new Twopotal(new String[15][20], "õ�� ������ 2", 3, 1, 13, 13, porest1, null);
		Onepotal porest3 = new Onepotal(new String[15][20], "õ�� ������ 3", 3, 1, porest2);
		Twopotal castle1 = new Twopotal(new String[10][20], "������ �� 1", 1, 5, 18, 5, town, null);
		Twopotal castle2 = new Twopotal(new String[10][20], "������ �� 2", 1, 5, 18, 5, castle1, null);
		Onepotal castle3 = new Onepotal(new String[10][20], "������ �� 3", 1, 5, castle2);
		
		
		rock1.potalnext2 = rock2;
		rock2.potalnext2 = rock3;
		
		porest1.potalnext2 = porest2;
		porest2.potalnext2 = porest3;
		
		castle1.potalnext2 = castle2;
		castle2.potalnext2 = castle3;
		
		town.potalnext1 = home;
		town.potalnext2 = nothing;
		town.npc1 = elder;
		town.npc2 = snow;
		town.npc3 = merchant;
		
		rock1.monster1 = slime1;
		rock2.monster1 = slime4;
		porest2.monster1 = slime2;
		castle2.monster1 = slime3;
		pond.npc1 = elf;
		
		rock3.monster1 = rockBoss;
		porest3.monster1 = porestBoss;
		castle3.monster1 = castleBoss;
		
		
		
		
		//���ʸ� ����
		player.nowmap = home;
		
		//���� �� ����
		//player.armor_inventory.add(noarmor);
		player.armor = noarmor;
		//���� ���� ����
		//player.weapon_inventory.add(noweapon);
		player.weapon = noweapon;
		
		
		
		
		
		
		// ������� ���� ����

		script.game_start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//{��Ż�̶� �÷��̾� ǥ������
		player.nowmap.map[player.nowmap.potalyLoca1][player.nowmap.potalxLoca1] = "@";
		player.nowmap.map[player.yLoca][player.xLoca] = player.art;
		//}��������� ���� �ѹ��� ���ָ��
		player.nowmap.map_print();
		
		
		RockBattleThread rockThread = new RockBattleThread();
		PorestBattleThread porestThread = new PorestBattleThread();
		CastleBattleThread castleThread = new CastleBattleThread();
		TimeThread time = new TimeThread();
		MusicThread music = new MusicThread();
		BattleMusic battlemusic = new BattleMusic();
		CastleMusic castlemusic = new CastleMusic();
		PorestMusic porestmusic = new PorestMusic();
		RockMusic rockmusic = new RockMusic();
		
		
		time.start();
		music.start();
		battlemusic.start();
		castlemusic.start();
		porestmusic.start();
		rockmusic.start();
		
		//music.suspend();
		battlemusic.suspend();
		castlemusic.suspend();
		porestmusic.suspend();
		rockmusic.suspend();
		
		//player.battle = battlemusic;
		player.castle = castlemusic;
		player.porest = porestmusic;
		player.rock = rockmusic;
		player.music = music;
		
		//�����丵 ������ : ������ �����, ��ǥ�� ���ƾ��ϴ°� �����ϴϱ� �װ� �� if�� ���� �� �Ʒ� if�� �� ������ ���� ����? ������
		while (true) {
			
			if(TimeThread.day.equals("��")) {
				castleBoss.art = "��";
				castleBoss.xLoca = 0;
				castleBoss.yLoca = 0;
			} else {
				castleBoss.art = "#";
				castleBoss.xLoca = 18;
				castleBoss.yLoca = 5;
			}
			
			if(player.nowmap == town) {
				castlemusic.suspend();
				porestmusic.suspend();
				rockmusic.suspend();
				music.resume();
			}
			else if(player.nowmap == rock1 || player.nowmap == rock2 || player.nowmap == rock3) {
			//	castlemusic.suspend();
			//	porestmusic.suspend();
				music.suspend();
				rockmusic.resume();
			}
			else if(player.nowmap == porest1 || player.nowmap == porest2 || player.nowmap == porest3) {
			//	castlemusic.suspend();
				porestmusic.resume();
				music.suspend();
			//	rockmusic.suspend();
			}
			else if(player.nowmap == castle1 || player.nowmap == castle2 || player.nowmap == castle3) {
				castlemusic.resume();
			//	porestmusic.suspend();
				music.suspend();
			//	rockmusic.suspend();
			}
			
			//�ƹ��͵� ������ ���
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && elder.art.equals("*"))
				script.nothingElder();
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && snow.art.equals("*"))
				script.nothingSnow();
			
			//����� Ŭ�����ϸ� �������� ������ �ʵ�����.
			//�����ٳ���� ��
			if(Script.clearPond) {
				script.home_start_cheak = false;
				script.elder_start_cheak = false;
				script.snowStartCheck = false;
				elder.art = "!";
				snow.art = "!";
				script.elderPhase2 = true;
				script.snowPhase2 = true;
				Script.clearPond = false;
				//������ �ٳ��
			} else if (Script.clearRock) {
				script.elderPhase2 = false;
				script.snowPhase2 = false;
				elder.art = "!";
				snow.art = "!";
				script.elderPhase3 = true;
				script.snowPhase3 = true;
				Script.clearRock = false;
				//�� �ٳ��
			} else if(Script.clearporest) {
				script.elderPhase3 = false;
				script.snowPhase3 = false;
				elder.art = "!";
				snow.xLoca = 0;
				snow.yLoca = 0;
				snow.art = "��";
				script.elderPhase4 = true;
				Script.clearporest = false;
			}
			
				
			if(player.nowmap == town)
				town.potalnext2 = nothing;
			
			if(player.nowmap == nothing) {
				System.out.println("�̵��ϰ� ���� ������ �Է����ּ���.");
				System.out.println("1 : ����");
				System.out.println("2 : ������");
				System.out.println("3 : õ��");
				System.out.println("4 : ī��Ÿ�Ǿ� ���");
				System.out.println("�̿��� ���� �����ϸ� ���ư��ϴ�.");
				select = scan.nextInt();
				
			if(select == 1) {
				town.potalnext2 = pond;
				player.nowmap = pond;
				pond.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
			else if(select == 2) {
				town.potalnext2 = rock1;
				player.nowmap = rock1;
				rock1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
				
			}else if(select == 3) {
				town.potalnext2 = porest1;
				player.nowmap = porest1;
				porest1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}else if(select == 4) {
				TimeThread.time = 0;
				TimeThread.day = "��";
				town.potalnext2 = castle1;
				player.nowmap = castle1;
				castle1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
				
			}
			
			if(player.nowmap == town && player.xLoca == merchant.xLoca && player.yLoca == merchant.yLoca) {
				merchant.metStore();
			}
			//���
			
			//�� ������ �� �������� ��簡 ��µ��� �ʰ���
			if(player.nowmap != home)
				script.home_start_cheak = false;
			
			//���������� ���
			if(script.home_start_cheak == true)
				script.home_start();
			//�����Ҷ� ��ȭ ���
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowStartCheck == true) {
				script.snowStart();
				script.snowStartCheck = false;
				snow.art = "*";
			}
			
			//��θ����� ��������� ���
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elder_start_cheak == true) {
				script.elder_start();
				script.elder_start_cheak = false;
				elder.art = "*";
			}
			

			if(player.nowmap == pond && player.xLoca == elf.xLoca && player.yLoca == elf.yLoca && elf.art.equals("!")) {
				System.out.println("====================================");
				System.out.println("���� : ����� ���ο� ��簡 �� ����ΰ� ������");
				System.out.println("���� : �ݰ����ϴ� ��翩.");
				System.out.println("���� : �� ���� �ް� ����� ����� �����ϼ���.");
				player.weapon_inventory.add(startsword);
				System.out.println("���� : �ȳ��������� ��翩. ����� ��� ����� �ֱ� ���ϴ�.");
				System.out.println("====================================");
				System.out.println("�κ��丮�� ������ ���� �߰��Ǿ����ϴ�.");
				System.out.println("");
				elf.art = "*";
				Script.clearPond = true;
			}
			
			if(player.nowmap == rock3 && rockThread.rockBoss_start_cheak == true) {
				rockThread.monster = rockBoss;
				rockThread.start();
				rockThread.rockBoss_start_cheak = false;
			}
			
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowPhase2 == true) {
				script.wentToPond();
				script.snowPhase2 = false;
				snow.art = "*";
				player.armor_inventory.add(startarmor);
			}
			
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase2 == true) {
				script.goToRock();
				script.elderPhase2 = false;
				elder.art = "*";
			}
			
		if(RockBattleThread.rockThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			RockBattleThread.rockThreadEnd = false;
		}
		
		if(PorestBattleThread.porestThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			PorestBattleThread.porestThreadEnd = false;
		}
		
		if(CastleBattleThread.castleThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			CastleBattleThread.castleThreadEnd = false;
		}
			
		if(player.nowmap == porest3 && porestThread.porestBoss_start_cheak == true) {
			porestThread.monster = porestBoss;
			porestThread.start();
			porestThread.porestBoss_start_cheak = false;
		}
		
		if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowPhase3 == true) {
			script.wentToRock();
			script.snowPhase3 = false;
			snow.art = "*";
		}
		
		if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase3 == true) {
			script.goToPorest();
			script.elderPhase3 = false;
			elder.art = "*";
		}
		
		if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase4 == true) {
			script.goToCastle();
			script.elderPhase4 = false;
			elder.art = "*";
		}
		
		if(player.nowmap == castle3 && castleThread.castleBoss_start_cheak == true) {
			castleThread.monster = castleBoss;
			castleThread.start();
			castleThread.castleBoss_start_cheak = false;
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
