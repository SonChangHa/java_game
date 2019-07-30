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

	public ArrayList<Armor> armor_inventory = new ArrayList<Armor>();// Àåºñ¾ÆÀÌÅÛ
	public ArrayList<Weapon> weapon_inventory = new ArrayList<Weapon>();// Àåºñ¾ÆÀÌÅÛ
	public ArrayList<Portion> portion_inventory = new ArrayList<Portion>();// Æ÷¼Ç
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
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("ÇÃ·¹ÀÌ¾îÀÇ ÀÌ¸§ : " + this.name);
		System.out.println("Ã¼·Â : " + this.nowhp + "/" + this.hp + ", ¸¶³ª : " + this.nowmp + "/" + this.mp);
		System.out.println("°ø°Ý·Â : " + this.ad + ", ¹æ¾î·Â : " + this.dp);
		System.out.println("Å©¸®Æ¼ÄÃ È®·ü : " + this.criticalRate + " %" + ", È¸ÇÇÀ² : " + this.avd + " %");
		System.out.println("°æÇèÄ¡ : " + this.nowexp + "/" + this.exp + ", °ñµå : " + this.gold);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println("");
		System.out.println("¾ÆÀÌÅÛ : 1, ½ºÅ³ : 2, ¸ÊÀ¸·Î µ¹¾Æ°¡±â : ±âÅ¸ ¼ýÀÚ");
		System.out.println("¾î¶² Çàµ¿À» ÇÏ½Ã°Ú½À´Ï±î?");
		input = scan.nextInt();
		switch (input) {
		case 1://Àåºñ
			System.out.println("¹«±â : 1, ¹æ¾î±¸ : 2, Æ÷¼Ç : 3, ¸ÊÀ¸·Î µ¹¾Æ°¡±â : ±âÅ¸ ¼ýÀÚ");
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

		case 2://½ºÅ³

			System.out.println("È¸º¹½ºÅ³ : 1, ¸ÊÀ¸·Î µ¹¾Æ°¡±â : ±âÅ¸ ¼ýÀÚ");
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
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("ÇöÀç ÀåÂøÁßÀÎ ¹«±â : " + this.weapon.name);
			System.out.println("Ãß°¡ °ø°Ý·Â : " + this.weapon.ad + ", Å©¸®Æ¼ÄÃ È®·ü : " + this.weapon.criticalRate);
		//	System.out.println("¹«±â ½ºÅ³ = " + this.swordSkill.name + ", ¼Ò¸ð ¸¶³ª : " + this.swordSkill.useMp + ", µ¥¹ÌÁö : " + this.swordSkill.damage + ", ½ºÅ³ ¼³¸í : " + this.swordSkill.what);
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("");

			// ¹«±â Ãâ·Â
			System.out.println("¹«±â ÀÎº¥Åä¸®");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Weapon item : this.weapon_inventory) {
				System.out.println(i + " : " + item.name + " = Ãß°¡ °ø°Ý·Â : " + item.ad + ", Å©¸®Æ¼ÄÃ È®·ü : " + item.criticalRate);
				i++;
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");

			System.out.println("¹«±â¸¦ ÀåÂøÇÏ°í ½ÍÀ¸½Ã¸é ¹«±âÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("ÀÌ¿ÜÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¸ÊÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
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
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("ÇöÀç ÀåÂøÁßÀÎ ¹æ¾î±¸ : " + this.armor.name);
			System.out.println("Ãß°¡ Ã¼·Â : " + this.armor.hp + ", Ãß°¡ ¹æ¾î·Â : " + this.armor.dp + ", È¸ÇÇÀ² : " + this.armor.avd);
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("");

			System.out.println("¹æ¾î±¸ ÀÎº¥Åä¸®");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Armor item : this.armor_inventory) {
				System.out.println(i + " : " + item.name + " = Ãß°¡ Ã¼·Â : " + item.hp + ", Ãß°¡ ¹æ¾î·Â : " + item.dp
						+ ", È¸ÇÇÀ² : " + item.avd);
				i++;
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");

			System.out.println("¹æ¾î±¸¸¦ ÀåÂøÇÏ°í ½ÍÀ¸½Ã¸é ¹æ¾î±¸ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("ÀÌ¿ÜÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¸ÊÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
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
			System.out.println("Æ÷¼Ç ÀÎº¥Åä¸®");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Portion item : this.portion_inventory) {
				System.out.println(i + " : " + item.name + " = °³¼ö : " + item.many + ", È¸º¹ Ã¼·Â : " + item.healHp
						+ ", È¸º¹ ¸¶³ª : " + item.healMp);
				i++;
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("Æ÷¼ÇÀ» »ç¿ëÇÏ°í ½ÍÀ¸½Ã¸é Æ÷¼ÇÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("ÀÌ¿ÜÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¸ÊÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
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
			System.out.println("½ºÅ³ºÏ ÀÎº¥Åä¸®");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (SkillBook item : this.skillBook_inventory) {
				System.out.println(i + " : " + item.name + " = ½ºÅ³ : " + item.skill.name);
				i++;
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("½ºÅ³ºÏÀ» »ç¿ëÇÏ°í ½ÍÀ¸½Ã¸é ½ºÅ³ºÏÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("ÀÌ¿ÜÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¸ÊÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
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
			System.out.println("È¸º¹ ½ºÅ³ ¸ñ·Ï");
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			for (Heal skill : this.healskill_list) {
				System.out.println(i + " : " + skill.name + " = ¼Ò¸ð ¸¶³ª : " + skill.useMp + ", È¸º¹ Ã¼·Â :"
						+ skill.skill_healHp + ", ½ºÅ³ ¼³¸í : " + skill.what);
				i++;
			}
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("È¸º¹ ½ºÅ³À» »ç¿ëÇÏ°í ½ÍÀ¸½Ã¸é ½ºÅ³ÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("ÀÌ¿ÜÀÇ ¼ýÀÚ¸¦ ÀÔ·ÂÇÏ¸é ¸ÊÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
			input = scan.nextInt();

			if (input > 0 && input <= i && healskill_list.size() != 0)
				Heal.use_heal(healskill_list.get(input - 1));
			else
				break;

			System.out.println("");

		}

	}

	// »ó´ë¿Í Á¶¿ìÇÏ¿´À»¶§ ÀüÅõ ½ÃÀÛ
	
	//¸Å°³º¯¼ö¸¦ null·Î ¹Ù²Ù¸é ½½¶óÀÓµµ ³ÎÀÌ µÈ´Ù?
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

		System.out.println(monster.name + "°ú ¸¸³µ½À´Ï´Ù!");

		while (true) {

			System.out.println("°ø°Ý : 1, ¸ó½ºÅÍ Á¤º¸ : 2, " + this.swordSkill.name + "(" + this.swordSkill.useMp + ") : 3, È¸º¹ ½ºÅ³ : 4, ¾ÆÀÌÅÛ : 5, µµÁÖ : 6");
			System.out.println("¾î¶² Çàµ¿À» ÇÏ½Ã°Ú½À´Ï±î?");
			input = scan.nextInt();
			
			for (int a = 0; a < 50; a++)
				System.out.println();
			
			switch (input) {
			case 1:
				this.player_battle_att(monster);// ÇÃ·¹ÀÌ¾î´Â µ¿ÀÛÀÌ ´Ù¸£Áö¸¸ ¸ó½ºÅÍ´Â °ø°Ý¸¸ ÇÔ.
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
				System.out.println("°£½ÅÈ÷ µµ¸ÁÃÆ½À´Ï´Ù!");
				this.nowmap.map[this.yLoca][this.xLoca] = this.art;
				battle.stop();
				return;
			}
			
			
				
			if (monster.nowhp <= 0) {
				// ¸ó½ºÅÍ Á×¾úÀ½.
				System.out.println("¸ó½ºÅÍ¸¦ ¹°¸®ÃÆ½À´Ï´Ù.");
				this.gold += monster.dropGold;
				this.nowexp += monster.dropExp;
				System.out.println("°ñµå¸¦ È¹µæÇÏ¿´½À´Ï´Ù! +" + monster.dropGold);
				System.out.println("°æÇèÄ¡¸¦ È¹µæÇÏ¿´½À´Ï´Ù! +" + monster.dropExp);
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
				// ÇÃ·¹ÀÌ¾î Á×¾úÀ½. °ÔÀÓ¿À¹ö
				System.out.println("ÇÃ·¹ÀÌ¾îÀÇ Ã¼·ÂÀÌ 0ÀÌ µÇ¾ú½À´Ï´Ù.");
				System.out.println("°ÔÀÓ¿À¹ö");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "ÀÇ ³²Àº Ã¼·ÂÀº " + this.nowhp + "/" + this.hp);
			System.out.println(monster.name + "ÀÇ ³²Àº Ã¼·ÂÀº " + monster.nowhp + "/" + monster.hp);
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("");

		}
	}

	public void show_monster(Monster monster) {
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println(monster.name);
		System.out.println("°ø°Ý·Â : " + monster.ad + ", ¹æ¾î·Â : " + monster.dp);
		System.out.println("Å©¸®Æ¼ÄÃ È®·ü : " + monster.criticalRate + ", È¸ÇÇÀ² : " + monster.avd);
		System.out.println(monster.name + "ÀÇ ³²Àº Ã¼·ÂÀº " + monster.nowhp + "/" + monster.hp);
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
	}
	
	/*public void npc_encounter(NPC npc) {

		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 50; a++)
			System.out.println();

		System.out.println(npc.name + "°ú ¸¸³µ½À´Ï´Ù!");
		System.out.println("ÀÚ³× µµµ¥Ã¼ ¹«½¼ÁþÀÎ°¡?");

		while (true) {
			System.out.println("°ø°Ý : 1, ½ºÅ³ : 2, ¾ÆÀÌÅÛ : 3, µµÁÖ : 4");
			System.out.println("¾î¶² Çàµ¿À» ÇÏ½Ã°Ú½À´Ï±î?");
			input = scan.nextInt();
			
			if (input == 1)
				this.player_battle_att(npc);// ÇÃ·¹ÀÌ¾î´Â µ¿ÀÛÀÌ ´Ù¸£Áö¸¸ ¸ó½ºÅÍ´Â °ø°Ý¸¸ ÇÔ.
			if (npc.nowhp <= 0) {
				// ¸ó½ºÅÍ Á×¾úÀ½.
				System.out.println("´ç½ÅÀº " + npc.name + "¸¦ Á×¿´½À´Ï´Ù.");
				nowmap.map[npc.yLoca][npc.xLoca] = this.art;
				npc = null;
				return;
			}
			npc.NPC_battle_att();
			if (this.nowhp <= 0) {
				// ÇÃ·¹ÀÌ¾î Á×¾úÀ½. °ÔÀÓ¿À¹ö
				System.out.println("ÇÃ·¹ÀÌ¾îÀÇ Ã¼·ÂÀÌ 0ÀÌ µÇ¾ú½À´Ï´Ù.");
				System.out.println("°ÔÀÓ¿À¹ö");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "ÀÇ ³²Àº Ã¼·ÂÀº " + this.nowhp + "/" + this.hp);
			System.out.println(npc.name + "ÀÇ ³²Àº Ã¼·ÂÀº " + npc.nowhp + "/" + npc.hp);
			System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
			System.out.println("");

		}
	}*/

	public void player_battle_att(Character monster) {
		
		System.out.println("");
		System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
		System.out.println(this.name + "ÀÇ °ø°Ý!");

		this.damage = this.ad - monster.dp; // µ¥¹ÌÁö´Â °ø°Ý·Â - ¹æ¾î·Â

		if (this.ad <= monster.dp) { // ¹æ¾î·ÂÀÌ ³ôÀ¸¸é µ©Áö 1
			this.damage = 1;
			monster.nowhp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // Å©¸®

		battle_Avoid(); // È¸ÇÇ

		monster.nowhp -= this.damage; // ³²Àº HP´Â HP »©±â µ¥¹ÌÁö·Î
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
			System.out.println("·¹º§ÀÌ »ó½ÂÇÏ¿´½À´Ï´Ù!");
			System.out.println("½ºÅÝÀÌ º¯È­ÇÏ¿´½À´Ï´Ù.");
		}
		
	}

}
