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

	public ArrayList<Armor> armor_inventory = new ArrayList<Armor>();// 濰綠嬴檜蠱
	public ArrayList<Weapon> weapon_inventory = new ArrayList<Weapon>();// 濰綠嬴檜蠱
	public ArrayList<Portion> portion_inventory = new ArrayList<Portion>();// ん暮
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
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("Ы溯檜橫曖 檜葷 : " + this.name);
		System.out.println("羹溘 : " + this.nowhp + "/" + this.hp + ", 葆釭 : " + this.nowmp + "/" + this.mp);
		System.out.println("奢問溘 : " + this.ad + ", 寞橫溘 : " + this.dp);
		System.out.println("觼葬じ鏽 �捕� : " + this.criticalRate + " %" + ", �裔Ш� : " + this.avd + " %");
		System.out.println("唳я纂 : " + this.nowexp + "/" + this.exp + ", 埤萄 : " + this.gold);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("");
		System.out.println("嬴檜蠱 : 1, 蝶鑒 : 2, 裘戲煎 給嬴陛晦 : 晦顫 璋濠");
		System.out.println("橫雯 ч翕擊 ж衛啊蝗棲梱?");
		input = scan.nextInt();
		switch (input) {
		case 1://濰綠
			System.out.println("鼠晦 : 1, 寞橫掘 : 2, ん暮 : 3, 裘戲煎 給嬴陛晦 : 晦顫 璋濠");
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

		case 2://蝶鑒

			System.out.println("�蛹厭瘍� : 1, 裘戲煎 給嬴陛晦 : 晦顫 璋濠");
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
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("⑷營 濰雜醞檣 鼠晦 : " + this.weapon.name);
			System.out.println("蹺陛 奢問溘 : " + this.weapon.ad + ", 觼葬じ鏽 �捕� : " + this.weapon.criticalRate);
		//	System.out.println("鼠晦 蝶鑒 = " + this.swordSkill.name + ", 模賅 葆釭 : " + this.swordSkill.useMp + ", 等嘐雖 : " + this.swordSkill.damage + ", 蝶鑒 撲貲 : " + this.swordSkill.what);
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("");

			// 鼠晦 轎溘
			System.out.println("鼠晦 檣漸饜葬");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Weapon item : this.weapon_inventory) {
				System.out.println(i + " : " + item.name + " = 蹺陛 奢問溘 : " + item.ad + ", 觼葬じ鏽 �捕� : " + item.criticalRate);
				i++;
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

			System.out.println("鼠晦蒂 濰雜ж堅 談戲衛賊 鼠晦曖 璋濠蒂 殮溘п輿撮蹂.");
			System.out.println("檜諼曖 璋濠蒂 殮溘ж賊 裘戲煎 給嬴骨棲棻.");
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
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("⑷營 濰雜醞檣 寞橫掘 : " + this.armor.name);
			System.out.println("蹺陛 羹溘 : " + this.armor.hp + ", 蹺陛 寞橫溘 : " + this.armor.dp + ", �裔Ш� : " + this.armor.avd);
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("");

			System.out.println("寞橫掘 檣漸饜葬");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Armor item : this.armor_inventory) {
				System.out.println(i + " : " + item.name + " = 蹺陛 羹溘 : " + item.hp + ", 蹺陛 寞橫溘 : " + item.dp
						+ ", �裔Ш� : " + item.avd);
				i++;
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");

			System.out.println("寞橫掘蒂 濰雜ж堅 談戲衛賊 寞橫掘曖 璋濠蒂 殮溘п輿撮蹂.");
			System.out.println("檜諼曖 璋濠蒂 殮溘ж賊 裘戲煎 給嬴骨棲棻.");
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
			System.out.println("ん暮 檣漸饜葬");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Portion item : this.portion_inventory) {
				System.out.println(i + " : " + item.name + " = 偃熱 : " + item.many + ", �蛹� 羹溘 : " + item.healHp
						+ ", �蛹� 葆釭 : " + item.healMp);
				i++;
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("ん暮擊 餌辨ж堅 談戲衛賊 ん暮曖 璋濠蒂 殮溘п輿撮蹂.");
			System.out.println("檜諼曖 璋濠蒂 殮溘ж賊 裘戲煎 給嬴骨棲棻.");
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
			System.out.println("蝶鑒磁 檣漸饜葬");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (SkillBook item : this.skillBook_inventory) {
				System.out.println(i + " : " + item.name + " = 蝶鑒 : " + item.skill.name);
				i++;
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("蝶鑒磁擊 餌辨ж堅 談戲衛賊 蝶鑒磁曖 璋濠蒂 殮溘п輿撮蹂.");
			System.out.println("檜諼曖 璋濠蒂 殮溘ж賊 裘戲煎 給嬴骨棲棻.");
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
			System.out.println("�蛹� 蝶鑒 跡煙");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			for (Heal skill : this.healskill_list) {
				System.out.println(i + " : " + skill.name + " = 模賅 葆釭 : " + skill.useMp + ", �蛹� 羹溘 :"
						+ skill.skill_healHp + ", 蝶鑒 撲貲 : " + skill.what);
				i++;
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("�蛹� 蝶鑒擊 餌辨ж堅 談戲衛賊 蝶鑒曖 璋濠蒂 殮溘п輿撮蹂.");
			System.out.println("檜諼曖 璋濠蒂 殮溘ж賊 裘戲煎 給嬴骨棲棻.");
			input = scan.nextInt();

			if (input > 0 && input <= i && healskill_list.size() != 0)
				Heal.use_heal(healskill_list.get(input - 1));
			else
				break;

			System.out.println("");

		}

	}

	// 鼻渠諦 褻辦ж艘擊陽 瞪癱 衛濛
	
	//衙偃滲熱蒂 null煎 夥紱賊 蝸塭歜紫 割檜 脹棻?
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

		System.out.println(monster.name + "婁 虜陬蝗棲棻!");

		while (true) {

			System.out.println("奢問 : 1, 跨蝶攪 薑爾 : 2, " + this.swordSkill.name + "(" + this.swordSkill.useMp + ") : 3, �蛹� 蝶鑒 : 4, 嬴檜蠱 : 5, 紫輿 : 6");
			System.out.println("橫雯 ч翕擊 ж衛啊蝗棲梱?");
			input = scan.nextInt();
			
			for (int a = 0; a < 50; a++)
				System.out.println();
			
			switch (input) {
			case 1:
				this.player_battle_att(monster);// Ы溯檜橫朝 翕濛檜 棻腦雖虜 跨蝶攪朝 奢問虜 л.
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
				System.out.println("除褐�� 紫蜂蟻蝗棲棻!");
				this.nowmap.map[this.yLoca][this.xLoca] = this.art;
				battle.stop();
				return;
			}
			
			
				
			if (monster.nowhp <= 0) {
				// 跨蝶攪 避歷擠.
				System.out.println("跨蝶攪蒂 僭葬蟻蝗棲棻.");
				this.gold += monster.dropGold;
				this.nowexp += monster.dropExp;
				System.out.println("埤萄蒂 �僱磈狤晾懂炴�! +" + monster.dropGold);
				System.out.println("唳я纂蒂 �僱磈狤晾懂炴�! +" + monster.dropExp);
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
				// Ы溯檜橫 避歷擠. 啪歜螃幗
				System.out.println("Ы溯檜橫曖 羹溘檜 0檜 腎歷蝗棲棻.");
				System.out.println("啪歜螃幗");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "曖 陴擎 羹溘擎 " + this.nowhp + "/" + this.hp);
			System.out.println(monster.name + "曖 陴擎 羹溘擎 " + monster.nowhp + "/" + monster.hp);
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("");

		}
	}

	public void show_monster(Monster monster) {
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println(monster.name);
		System.out.println("奢問溘 : " + monster.ad + ", 寞橫溘 : " + monster.dp);
		System.out.println("觼葬じ鏽 �捕� : " + monster.criticalRate + ", �裔Ш� : " + monster.avd);
		System.out.println(monster.name + "曖 陴擎 羹溘擎 " + monster.nowhp + "/" + monster.hp);
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
	}
	
	/*public void npc_encounter(NPC npc) {

		Scanner scan = new Scanner(System.in);
		int input;
		for (int a = 0; a < 50; a++)
			System.out.println();

		System.out.println(npc.name + "婁 虜陬蝗棲棻!");
		System.out.println("濠啻 紫等羹 鼠蝦騁檣陛?");

		while (true) {
			System.out.println("奢問 : 1, 蝶鑒 : 2, 嬴檜蠱 : 3, 紫輿 : 4");
			System.out.println("橫雯 ч翕擊 ж衛啊蝗棲梱?");
			input = scan.nextInt();
			
			if (input == 1)
				this.player_battle_att(npc);// Ы溯檜橫朝 翕濛檜 棻腦雖虜 跨蝶攪朝 奢問虜 л.
			if (npc.nowhp <= 0) {
				// 跨蝶攪 避歷擠.
				System.out.println("渡褐擎 " + npc.name + "蒂 避艘蝗棲棻.");
				nowmap.map[npc.yLoca][npc.xLoca] = this.art;
				npc = null;
				return;
			}
			npc.NPC_battle_att();
			if (this.nowhp <= 0) {
				// Ы溯檜橫 避歷擠. 啪歜螃幗
				System.out.println("Ы溯檜橫曖 羹溘檜 0檜 腎歷蝗棲棻.");
				System.out.println("啪歜螃幗");
				System.exit(0);
				return;
			}
			System.out.println(this.name + "曖 陴擎 羹溘擎 " + this.nowhp + "/" + this.hp);
			System.out.println(npc.name + "曖 陴擎 羹溘擎 " + npc.nowhp + "/" + npc.hp);
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			System.out.println("");

		}
	}*/

	public void player_battle_att(Character monster) {
		
		System.out.println("");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println(this.name + "曖 奢問!");

		this.damage = this.ad - monster.dp; // 等嘐雖朝 奢問溘 - 寞橫溘

		if (this.ad <= monster.dp) { // 寞橫溘檜 堪戲賊 筒雖 1
			this.damage = 1;
			monster.nowhp -= this.damage;
			System.out.println("-" + this.damage + "!!!");
			return;
		}

		battle_critical(); // 觼葬

		battle_Avoid(); // �裔�

		monster.nowhp -= this.damage; // 陴擎 HP朝 HP 貍晦 等嘐雖煎
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
			System.out.println("溯漣檜 鼻蝓ж艘蝗棲棻!");
			System.out.println("蝶邐檜 滲�倆狤晾懂炴�.");
		}
		
	}

}
