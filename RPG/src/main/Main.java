package main;

import character.*;
import java.util.Scanner;
import equip_Item.*;
import map.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String move;

		
		
		Dungeon1 dungeon = new Dungeon1(new String[30][60]);

		Town town = new Town(new String[20][40], 5, 5, 8, 8, dungeon, dungeon);

		Store store = new Store(new String[10][20], 3, 3, town);// [x��ǥ][y��ǥ]

		// �÷��̾� ��ü ����(�̸�, hp, mp, ad, dp, cri, avd, x��ǥ, y��ǥ, ǥ�ù���
		Player player = new Player("�ڹٸ� �ϴ� â��", 50, 10, 10, 10, 10, 10, 1, 2, "+");
		player.nowmap = store;
		//�÷��̾�� �ٲ��� �ʴ� ���̴ϱ� ����ƽ �����ص���
		Monster.player = player;
		MyMap.player = player;

		// �� ��ü ���� (�̸�, ����, ������, hp, dp, avd)
		Armor armor1 = new Armor("������ ���� �������� ������ �ʴ� ��ö��Ż", 1, 1, 1, 1, 1);

		// ���� ��ü ����
		Monster ork = new Monster("�ڹ� ������ ���� ��������", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		
		store.monster1 = ork;

		System.out.println("���� ���� ����Ƥ�����������");

		player.nowmap = store;
		while (true) {
			move = scan.nextLine();
			player.nowmap.map_all(move);
		}

	}// ���θ޼ҵ�

}
