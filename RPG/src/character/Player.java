package character;

import map.MyMap;
import music.*;
import skill.*;
import use_item.*;

import java.util.*;

import battleThread.RockBattleThread;
import equip_Item.*;

public class Player extends Character {
	
	public boolean battleSwitch = false;
	
	//public BattleMusic battle;
	public CastleMusic castle;
	public PorestMusic porest;
	public MusicThread music;
	public RockMusic rock;
	
	public int lv = 1;
	public int exp = 300;
	public int nowexp = 0;
	public int gold = 100;
	
	public int nowhp; 
	public int nowmp;
	
	public NPC npc;

	public Weapon weapon;
	public Armor armor;
	public MyMap nowmap;
	
	public SwordSkill swordSkill = null;

	public ArrayList<Armor> armor_inventory = new ArrayList<Armor>();// ��������
	public ArrayList<Weapon> weapon_inventory = new ArrayList<Weapon>();// ��������
	public ArrayList<Portion> portion_inventory = new ArrayList<Portion>();// ����
	public ArrayList<Heal> healskill_list = new ArrayList<Heal>();
	public ArrayList<SkillBook> skillBook_inventory = new ArrayList<SkillBook>();

	public Player(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
	}

	public void show_menu() {
		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 50; a++)
			System.out.println();
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("�÷��̾��� �̸� : " + this.name);
		System.out.println("ü�� : " + this.nowhp + "/" + this.hp + ", ���� : " + this.nowmp + "/" + this.mp);
		System.out.println("���ݷ� : " + this.ad + ", ���� : " + this.dp);
		System.out.println("ũ��Ƽ�� Ȯ�� : " + this.criticalRate + " %" + ", ȸ���� : " + this.avd + " %");
		System.out.println("����ġ : " + this.nowexp + "/" + this.exp + ", ��� : " + this.gold);
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println("������ : 1, ��ų : 2, ������ ���ư��� : ��Ÿ ����");
		System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?");
		input = scan.nextInt();
		switch (input) {
		case 1://���
			System.out.println("���� : 1, �� : 2, ���� : 3, ������ ���ư��� : ��Ÿ ����");
			input = scan.nextInt();
			switch (input) {
			case 1:
				for (int a = 0; a < 50; a++)
					System.out.println();
				show_weapon();
				break;
			case 2:
				for (int a = 0; a < 50; a++)
					System.out.println();
				show_armor();
				break;
			case 3:
				for (int a = 0; a < 50; a++)
					System.out.println();
				show_portion();
				break;
			default:
				return;
			}
			break;

		case 2://��ų

			System.out.println("ȸ����ų : 1, ������ ���ư��� : ��Ÿ ����");
			input = scan.nextInt();
			switch (input) {
			case 1:
				for (int a = 0; a < 50; a++)
					System.out.println();
				show_healskill();
				break;
			case 2:
				for (int a = 0; a < 50; a++)
					System.out.println();
				// show_armor();
				break;
			case 3:
				for (int a = 0; a < 50; a++)
					System.out.println();
				// show_portion();
				break;
			default:
				return;
			}

		default:
			return;
		}

	}

	public void show_weapon() {
		Scanner scan = new Scanner(System.in);
		int input;
		int i = 1;
		while (true) {
			i = 1;
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("���� �������� ���� : " + this.weapon.name);
			System.out.println("�߰� ���ݷ� : " + this.weapon.ad + ", ũ��Ƽ�� Ȯ�� : " + this.weapon.criticalRate);
		//	System.out.println("���� ��ų = " + this.swordSkill.name + ", �Ҹ� ���� : " + this.swordSkill.useMp + ", ������ : " + this.swordSkill.damage + ", ��ų ���� : " + this.swordSkill.what);
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("");

			// ���� ���
			System.out.println("���� �κ��丮");
			System.out.println("��������������������������������������������������������������������������������");
			for (Weapon item : this.weapon_inventory) {
				System.out.println(i + " : " + item.name + " = �߰� ���ݷ� : " + item.ad + ", ũ��Ƽ�� Ȯ�� : " + item.criticalRate);
				i++;
			}
			System.out.println("��������������������������������������������������������������������������������");

			System.out.println("���⸦ �����ϰ� �����ø� ������ ���ڸ� �Է����ּ���.");
			System.out.println("�̿��� ���ڸ� �Է��ϸ� ������ ���ư��ϴ�.");
			input = scan.nextInt();

			if (input > 0 && input <= i)
				Weapon.weapon_equip(weapon_inventory.get(input - 1));
			else
				break;

			System.out.println("");
		}
	}

	public void show_armor() {
		Scanner scan = new Scanner(System.in);
		int input, i = 1;
		while (true) {
			i = 1;
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("���� �������� �� : " + this.armor.name);
			System.out.println("�߰� ü�� : " + this.armor.hp + ", �߰� ���� : " + this.armor.dp + ", ȸ���� : " + this.armor.avd);
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("");

			System.out.println("�� �κ��丮");
			System.out.println("��������������������������������������������������������������������������������");
			for (Armor item : this.armor_inventory) {
				System.out.println(i + " : " + item.name + " = �߰� ü�� : " + item.hp + ", �߰� ���� : " + item.dp
						+ ", ȸ���� : " + item.avd);
				i++;
			}
			System.out.println("��������������������������������������������������������������������������������");

			System.out.println("���� �����ϰ� �����ø� ���� ���ڸ� �Է����ּ���.");
			System.out.println("�̿��� ���ڸ� �Է��ϸ� ������ ���ư��ϴ�.");
			input = scan.nextInt();

			if (input > 0 && input <= i)
				Armor.armor_equip(armor_inventory.get(input - 1));
			else
				break;

			System.out.println("");
		}
	}

	public void show_portion() {
		Scanner scan = new Scanner(System.in);
		int input, i = 1;
		while (true) {
			i = 1;
			System.out.println("���� �κ��丮");
			System.out.println("��������������������������������������������������������������������������������");
			for (Portion item : this.portion_inventory) {
				System.out.println(i + " : " + item.name + " = ���� : " + item.many + ", ȸ�� ü�� : " + item.healHp
						+ ", ȸ�� ���� : " + item.healMp);
				i++;
			}
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("������ ����ϰ� �����ø� ������ ���ڸ� �Է����ּ���.");
			System.out.println("�̿��� ���ڸ� �Է��ϸ� ������ ���ư��ϴ�.");
			input = scan.nextInt();

			if (input > 0 && input <= i && portion_inventory.size() != 0)
				Portion.use_portion(portion_inventory.get(input - 1));
			else
				break;

			System.out.println("");
		}

	}

	public void show_skillbook() {
		Scanner scan = new Scanner(System.in);
		int input, i = 1;
		while (true) {
			i = 1;
			System.out.println("��ų�� �κ��丮");
			System.out.println("��������������������������������������������������������������������������������");
			for (SkillBook item : this.skillBook_inventory) {
				System.out.println(i + " : " + item.name + " = ��ų : " + item.skill.name);
				i++;
			}
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("��ų���� ����ϰ� �����ø� ��ų���� ���ڸ� �Է����ּ���.");
			System.out.println("�̿��� ���ڸ� �Է��ϸ� ������ ���ư��ϴ�.");
			input = scan.nextInt();

			if (input > 0 && input <= i && skillBook_inventory.size() != 0)
				SkillBook.use_skillbook(skillBook_inventory.get(input - 1));
			else
				break;

			System.out.println("");
		}

	}

	public void show_healskill() {
		Scanner scan = new Scanner(System.in);
		int input, i = 1;
		while (true) {
			i = 1;
			System.out.println("ȸ�� ��ų ���");
			System.out.println("��������������������������������������������������������������������������������");
			for (Heal skill : this.healskill_list) {
				System.out.println(i + " : " + skill.name + " = �Ҹ� ���� : " + skill.useMp + ", ȸ�� ü�� :"
						+ skill.skill_healHp + ", ��ų ���� : " + skill.what);
				i++;
			}
			System.out.println("��������������������������������������������������������������������������������");
			System.out.println("ȸ�� ��ų�� ����ϰ� �����ø� ��ų�� ���ڸ� �Է����ּ���.");
			System.out.println("�̿��� ���ڸ� �Է��ϸ� ������ ���ư��ϴ�.");
			input = scan.nextInt();

			if (input > 0 && input <= i && healskill_list.size() != 0)
				Heal.use_heal(healskill_list.get(input - 1));
			else
				break;

			System.out.println("");

		}

	}

	// ���� �����Ͽ����� ���� ����
	
	//�Ű������� null�� �ٲٸ� �����ӵ� ���� �ȴ�?
	public void monster_encounter(Monster monster) {
		
		battleSwitch = true;
		
		music.suspend();
		porest.suspend();
		rock.suspend();
		castle.suspend();
		BattleMusic battle = new BattleMusic();
		battle.start();
		
		
		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 50; a++)
			System.out.println();

		System.out.println(monster.name + "�� �������ϴ�!");

		while (true) {

			System.out.println("���� : 1, ���� ���� : 2, " + this.swordSkill.name + "(" + this.swordSkill.useMp + ") : 3, ȸ�� ��ų : 4, ������ : 5, ���� : 6");
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?");
			input = scan.nextInt();
			
			for (int a = 0; a < 50; a++)
				System.out.println();
			
			switch (input) {
			case 1:
				this.player_battle_att(monster);// �÷��̾�� ������ �ٸ����� ���ʹ� ���ݸ� ��.
				break;
				
			case 2:
				this.show_monster(monster);
				continue;
				
			case 3:
				this.swordSkill.swordSkill(monster);
				break;
				
			case 4:
				this.show_healskill();
				break;
			
			case 5:
				this.show_portion();
				break;
				
				

			default:
				System.out.println("������ �����ƽ��ϴ�!");
				this.nowmap.map[this.yLoca][this.xLoca] = this.art;
				battle.stop();
				return;
			}
			
			
				
			if (monster.nowhp <= 0) {
				// ���� �׾���.
				System.out.println("���͸� �����ƽ��ϴ�.");
				this.gold += monster.dropGold;
				this.nowexp += monster.dropExp;
				System.out.println("��带 ȹ���Ͽ����ϴ�! +" + monster.dropGold);
				System.out.println("����ġ�� ȹ���Ͽ����ϴ�! +" + monster.dropExp);
				if(this.nowexp >= this.exp)
					this.levelUp();
				this.nowmap.map[monster.yLoca][monster.xLoca] = this.art;
				monster = null;
				battleSwitch = false;
				battle.suspend();
				return;
			}
			monster.monster_battle_att();
			if (this.nowhp <= 0) {
				// �÷��̾� �׾���. ���ӿ���
				System.out.println("�÷��̾��� ü���� 0�� �Ǿ����ϴ�.");
				System.out.println("���ӿ���");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "�� ���� ü���� " + this.nowhp + "/" + this.hp);
			System.out.println(monster.name + "�� ���� ü���� " + monster.nowhp + "/" + monster.hp);
			System.out.println("��������������������������������������������������������");
			System.out.println("");

		}
	}

	public void show_monster(Monster monster) {
		System.out.println("��������������������������������������������������������");
		System.out.println(monster.name);
		System.out.println("���ݷ� : " + monster.ad + ", ���� : " + monster.dp);
		System.out.println("ũ��Ƽ�� Ȯ�� : " + monster.criticalRate + ", ȸ���� : " + monster.avd);
		System.out.println(monster.name + "�� ���� ü���� " + monster.nowhp + "/" + monster.hp);
		System.out.println("��������������������������������������������������������");
	}
	
	/*public void npc_encounter(NPC npc) {

		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 50; a++)
			System.out.println();

		System.out.println(npc.name + "�� �������ϴ�!");
		System.out.println("�ڳ� ����ü �������ΰ�?");

		while (true) {
			System.out.println("���� : 1, ��ų : 2, ������ : 3, ���� : 4");
			System.out.println("� �ൿ�� �Ͻðڽ��ϱ�?");
			input = scan.nextInt();
			
			if (input == 1)
				this.player_battle_att(npc);// �÷��̾�� ������ �ٸ����� ���ʹ� ���ݸ� ��.
			if (npc.nowhp <= 0) {
				// ���� �׾���.
				System.out.println("����� " + npc.name + "�� �׿����ϴ�.");
				nowmap.map[npc.yLoca][npc.xLoca] = this.art;
				npc = null;
				return;
			}
			npc.NPC_battle_att();
			if (this.nowhp <= 0) {
				// �÷��̾� �׾���. ���ӿ���
				System.out.println("�÷��̾��� ü���� 0�� �Ǿ����ϴ�.");
				System.out.println("���ӿ���");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "�� ���� ü���� " + this.nowhp + "/" + this.hp);
			System.out.println(npc.name + "�� ���� ü���� " + npc.nowhp + "/" + npc.hp);
			System.out.println("��������������������������������������������������������");
			System.out.println("");

		}
	}*/

	public void player_battle_att(Character monster) {
		
		System.out.println("");
		System.out.println("��������������������������������������������������������");
		System.out.println(this.name + "�� ����!");

		this.damage = this.ad - monster.dp; // �������� ���ݷ� - ����

		if (this.ad <= monster.dp) { // ������ ������ ���� 1
			this.damage = 1;
			monster.nowhp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // ũ��

		battle_Avoid(); // ȸ��

		monster.nowhp -= this.damage; // ���� HP�� HP ���� ��������
		System.out.println("-" + this.damage + "!!!");
	}
	
	public void levelUp(){
		while(this.nowexp < this.exp) {
			this.lv++;
			this.exp += 100;
			this.hp += 50;
			this.mp += 50;
			this.ad += 5;
			this.dp += 5;
			System.out.println("������ ����Ͽ����ϴ�!");
			System.out.println("������ ��ȭ�Ͽ����ϴ�.");
		}
		
	}

}
