package main;

import character.*;
import java.util.Scanner;
import equip_Item.*;
import map.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String move;

		// �÷��̾� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���
		Player player = new Player("�ڹٸ� �ϴ� â��", 50, 10, 10, 10, 10, 10, 1, 2, "+");

		// �� ��ü ���� (�̸�, ����, ������, hp, dp, avd)
		Armor armor1 = new Armor("������ ���� �������� ������ �ʴ� ��ö��Ż", 1, 1, 1, 1, 1);

		// ���� ��ü ����
		Monster ork = new Monster("�ڹ� ������ ���� ��������", 30, 10, 20, 10, 10, 10, 10, 10, "0");

		Monster.player = player;
		// �Ʒ��� ���� ���� ����ƽ���� �����ϸ� ��� monster�ν��Ͻ��� player ��� ����

		MyMap.player = player;
		MyMap.monster = ork;
		Store store = new Store(new String[20][40], 2, 2);// [x��ǥ][y��ǥ]
		// Town amap = new Town(new String[10][20], 1, 1, 3, 3);
		
		/*
		store.map_print();

		System.out.println();
		
		// �̰� �ؾ� ���Ͱ� �ٲ�
		player.monster = ork;
		
		 while (true) {
			move = scan.nextLine();
			store.map_all(move);
		}
		*/
		
		
		
		System.out.println("���� ���� ����Ƥ�����������");
		
		MyMap now;
		
		now = store;
		
		now.map_all(move);
		
		
		
		
		
		
		
	}//���θ޼ҵ�

}