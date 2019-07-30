package character;

import java.util.ArrayList;
import java.util.Scanner;

import equip_Item.Armor;
import equip_Item.Weapon;
import map.MyMap;
import skill.Heal;
import use_item.Portion;
import use_item.SkillBook;

public class NPC extends Character {

	public static Player player;
	
	public ArrayList<Armor> npc_armor_inventory = new ArrayList<Armor>();// 장비아이템
	public ArrayList<Weapon> npc_weapon_inventory = new ArrayList<Weapon>();// 장비아이템
	public ArrayList<Portion> npc_portion_inventory = new ArrayList<Portion>();// 포션
	public ArrayList<SkillBook> npc_skillBook_inventory = new ArrayList<SkillBook>();

	public NPC(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca, String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
	}
	
	public void metStore() {
		for (int a = 0; a < 50; a++)
			System.out.println();
		System.out.println("어서와!");
		System.out.println("무기는 1, 방어구는 2, 포션은 3, 스킬북은 4, 나가고싶으면 아무 숫자나 눌러줘!");
		Scanner scan = new Scanner(System.in);
		int input;
		input = scan.nextInt();
		switch (input) {
		//무기
		case 1:
			buyWeapon();
			break;

		case 2:	
			buyArmor();
			break;
			
		case 3:
			buyPortion();
			break;
		//스킬북	
		case 4:
			buySkillBook();
			break;	
			
		//나가기*/
		default:
			System.out.println("안녕히가세요!");
			break;
		} 
	}
	
	
	
	public void buyWeapon() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("────────────────────────────────────────");
		for (Weapon item : this.npc_weapon_inventory) {
			System.out.println(i + " : " + item.name + " = 추가 공격력 : " + item.ad + ", 크리티컬 확률 : " + item.criticalRate + " 가격은 " + item.pay);
			i++;
		}
		System.out.println("────────────────────────────────────────");
		System.out.println("구매하고 싶은 물건의 숫자를 입력해줘! 이외의 숫자를 입력하면 맵으로 돌아가!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_weapon_inventory.size() != 0) {
			if(npc_weapon_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("구매해줘서 고마워!");
				System.out.println("");
				player.gold -= npc_weapon_inventory.get(input - 1).pay;
				System.out.println("인벤토리에 " + npc_weapon_inventory.get(input - 1).name + "가 추가되었습니다.");
				System.out.println("남은 골드는 " + player.gold + "입니다.");
				
				player.weapon_inventory.add(npc_weapon_inventory.get(input - 1));
				npc_weapon_inventory.remove(input - 1);
			} else {
				System.out.println("골드가 부족해!");
			}
			
		}else {
			System.out.println("안녕히가세요!");
			break;
		}
		}
		
		
		
	}
	
	
	
	public void buyArmor() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("────────────────────────────────────────");
		for (Armor item : this.npc_armor_inventory) {
			System.out.println(i + " : " + item.name + " = 추가 체력 : " + item.hp + ", 추가 방어력 : " + item.dp
					+ ", 회피율 : " + item.avd + " 가격은 " + item.pay);
			i++;
		}
		System.out.println("────────────────────────────────────────");
		System.out.println("구매하고 싶은 물건의 숫자를 입력해줘! 이외의 숫자를 입력하면 맵으로 돌아가!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_armor_inventory.size() != 0) {
			if(npc_armor_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("구매해줘서 고마워!");
				System.out.println("");
				player.gold -= npc_armor_inventory.get(input - 1).pay;
				System.out.println("인벤토리에 " + npc_armor_inventory.get(input - 1).name + "가 추가되었습니다.");
				System.out.println("남은 골드는 " + player.gold + "입니다.");
				
				player.armor_inventory.add(npc_armor_inventory.get(input - 1));
				npc_armor_inventory.remove(input - 1);
			} else {
				System.out.println("골드가 부족해!");
			}
			
		}else {
			System.out.println("안녕히가세요!");
			break;
		}
		}
		
		
		
	}
	
	
	public void buyPortion() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("────────────────────────────────────────");
		for (Portion item : this.npc_portion_inventory) {
			System.out.println(i + " : " + item.name + " = 개수 : " + item.many + ", 회복 체력 : " + item.healHp
					+ ", 회복 마나 : " + item.healMp + " 가격은 " + item.pay);
			i++;
		}
		System.out.println("────────────────────────────────────────");
		System.out.println("구매하고 싶은 물건의 숫자를 입력해줘! 이외의 숫자를 입력하면 맵으로 돌아가!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_portion_inventory.size() != 0) {
			if(npc_portion_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("구매해줘서 고마워!");
				System.out.println("");
				player.gold -= npc_portion_inventory.get(input - 1).pay;
				System.out.println("인벤토리에 " + npc_portion_inventory.get(input - 1).name + "가 추가되었습니다.");
				System.out.println("남은 골드는 " + player.gold + "입니다.");
				
				player.portion_inventory.add(npc_portion_inventory.get(input - 1));
			} else {
				System.out.println("골드가 부족해!");
			}
			
		}else {
			System.out.println("안녕히가세요!");
			break;
		}
		}
		
		
		
	}
	
	
	
	public void buySkillBook() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("────────────────────────────────────────");
		for (SkillBook item : this.npc_skillBook_inventory) {
			System.out.println(i + " : " + item.name + " = 스킬 : " + item.skill.name + " 가격은 " + item.pay);
			i++;
		}
		System.out.println("────────────────────────────────────────");
		System.out.println("구매하고 싶은 물건의 숫자를 입력해줘! 이외의 숫자를 입력하면 맵으로 돌아가!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_skillBook_inventory.size() != 0) {
			if(npc_skillBook_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("구매해줘서 고마워!");
				System.out.println("");
				player.gold -= npc_skillBook_inventory.get(input - 1).pay;
				System.out.println("인벤토리에 " + npc_skillBook_inventory.get(input - 1).name + "가 추가되었습니다.");
				System.out.println("남은 골드는 " + player.gold + "입니다.");
				
				player.skillBook_inventory.add(npc_skillBook_inventory.get(input - 1));
				npc_skillBook_inventory.remove(input - 1);
			} else {
				System.out.println("골드가 부족해!");
			}
			
		}else {
			System.out.println("안녕히가세요!");
			break;
		}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
