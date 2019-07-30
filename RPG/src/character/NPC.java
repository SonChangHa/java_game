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
	
	public ArrayList<Armor> npc_armor_inventory = new ArrayList<Armor>();// ��������
	public ArrayList<Weapon> npc_weapon_inventory = new ArrayList<Weapon>();// ��������
	public ArrayList<Portion> npc_portion_inventory = new ArrayList<Portion>();// ����
	public ArrayList<SkillBook> npc_skillBook_inventory = new ArrayList<SkillBook>();

	public NPC(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca, String art) {
		super(name, hp, mp, ad, dp, criticalRate, avd, xLoca, yLoca, art);
		this.nowhp = hp;
		this.nowmp = mp;
	}
	
	public void metStore() {
		for (int a = 0; a < 50; a++)
			System.out.println();
		System.out.println("���!");
		System.out.println("����� 1, ���� 2, ������ 3, ��ų���� 4, ����������� �ƹ� ���ڳ� ������!");
		Scanner scan = new Scanner(System.in);
		int input;
		input = scan.nextInt();
		switch (input) {
		//����
		case 1:
			buyWeapon();
			break;

		case 2:	
			buyArmor();
			break;
			
		case 3:
			buyPortion();
			break;
		//��ų��	
		case 4:
			buySkillBook();
			break;	
			
		//������*/
		default:
			System.out.println("�ȳ���������!");
			break;
		} 
	}
	
	
	
	public void buyWeapon() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("��������������������������������������������������������������������������������");
		for (Weapon item : this.npc_weapon_inventory) {
			System.out.println(i + " : " + item.name + " = �߰� ���ݷ� : " + item.ad + ", ũ��Ƽ�� Ȯ�� : " + item.criticalRate + " ������ " + item.pay);
			i++;
		}
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("�����ϰ� ���� ������ ���ڸ� �Է�����! �̿��� ���ڸ� �Է��ϸ� ������ ���ư�!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_weapon_inventory.size() != 0) {
			if(npc_weapon_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("�������༭ ����!");
				System.out.println("");
				player.gold -= npc_weapon_inventory.get(input - 1).pay;
				System.out.println("�κ��丮�� " + npc_weapon_inventory.get(input - 1).name + "�� �߰��Ǿ����ϴ�.");
				System.out.println("���� ���� " + player.gold + "�Դϴ�.");
				
				player.weapon_inventory.add(npc_weapon_inventory.get(input - 1));
				npc_weapon_inventory.remove(input - 1);
			} else {
				System.out.println("��尡 ������!");
			}
			
		}else {
			System.out.println("�ȳ���������!");
			break;
		}
		}
		
		
		
	}
	
	
	
	public void buyArmor() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("��������������������������������������������������������������������������������");
		for (Armor item : this.npc_armor_inventory) {
			System.out.println(i + " : " + item.name + " = �߰� ü�� : " + item.hp + ", �߰� ���� : " + item.dp
					+ ", ȸ���� : " + item.avd + " ������ " + item.pay);
			i++;
		}
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("�����ϰ� ���� ������ ���ڸ� �Է�����! �̿��� ���ڸ� �Է��ϸ� ������ ���ư�!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_armor_inventory.size() != 0) {
			if(npc_armor_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("�������༭ ����!");
				System.out.println("");
				player.gold -= npc_armor_inventory.get(input - 1).pay;
				System.out.println("�κ��丮�� " + npc_armor_inventory.get(input - 1).name + "�� �߰��Ǿ����ϴ�.");
				System.out.println("���� ���� " + player.gold + "�Դϴ�.");
				
				player.armor_inventory.add(npc_armor_inventory.get(input - 1));
				npc_armor_inventory.remove(input - 1);
			} else {
				System.out.println("��尡 ������!");
			}
			
		}else {
			System.out.println("�ȳ���������!");
			break;
		}
		}
		
		
		
	}
	
	
	public void buyPortion() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("��������������������������������������������������������������������������������");
		for (Portion item : this.npc_portion_inventory) {
			System.out.println(i + " : " + item.name + " = ���� : " + item.many + ", ȸ�� ü�� : " + item.healHp
					+ ", ȸ�� ���� : " + item.healMp + " ������ " + item.pay);
			i++;
		}
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("�����ϰ� ���� ������ ���ڸ� �Է�����! �̿��� ���ڸ� �Է��ϸ� ������ ���ư�!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_portion_inventory.size() != 0) {
			if(npc_portion_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("�������༭ ����!");
				System.out.println("");
				player.gold -= npc_portion_inventory.get(input - 1).pay;
				System.out.println("�κ��丮�� " + npc_portion_inventory.get(input - 1).name + "�� �߰��Ǿ����ϴ�.");
				System.out.println("���� ���� " + player.gold + "�Դϴ�.");
				
				player.portion_inventory.add(npc_portion_inventory.get(input - 1));
			} else {
				System.out.println("��尡 ������!");
			}
			
		}else {
			System.out.println("�ȳ���������!");
			break;
		}
		}
		
		
		
	}
	
	
	
	public void buySkillBook() {
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) {
		int i = 1;
		System.out.println("��������������������������������������������������������������������������������");
		for (SkillBook item : this.npc_skillBook_inventory) {
			System.out.println(i + " : " + item.name + " = ��ų : " + item.skill.name + " ������ " + item.pay);
			i++;
		}
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("�����ϰ� ���� ������ ���ڸ� �Է�����! �̿��� ���ڸ� �Է��ϸ� ������ ���ư�!");
		input = scan.nextInt();
		
		if (input > 0 && input <= i && npc_skillBook_inventory.size() != 0) {
			if(npc_skillBook_inventory.get(input - 1).pay <= player.gold) {
				
				System.out.println("�������༭ ����!");
				System.out.println("");
				player.gold -= npc_skillBook_inventory.get(input - 1).pay;
				System.out.println("�κ��丮�� " + npc_skillBook_inventory.get(input - 1).name + "�� �߰��Ǿ����ϴ�.");
				System.out.println("���� ���� " + player.gold + "�Դϴ�.");
				
				player.skillBook_inventory.add(npc_skillBook_inventory.get(input - 1));
				npc_skillBook_inventory.remove(input - 1);
			} else {
				System.out.println("��尡 ������!");
			}
			
		}else {
			System.out.println("�ȳ���������!");
			break;
		}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
