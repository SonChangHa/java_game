package map;

import character.*;
import java.util.Random;

public class MyMap {

	public static String[][] map;
	public static Player player;
	public static Monster monster;
	public static int MonsterNum;// �ʵ忡 �����ִ� ������ ��
	public int potalxLoca1;
	public int potalyLoca1;
	public int potalxLoca2;
	public int potalyLoca2;

	public MyMap(String map[][]) {
		this.map = map;

		// ���� �ڵ���� ���� Ʋ�� ����� �ڵ�
		for (int down = 0; down < map.length; down++) {
			for (int side = 0; side < map[0].length; side++) {
				map[down][side] = "-";
			}
		}

		for (int down = 0; down < map.length; down++) {
			map[down][0] = "��";
			map[down][map[0].length - 1] = "��";
		}

		for (int side = 0; side < map[0].length; side++) {
			map[0][side] = "��";
			map[map.length - 1][side] = "��";
		}

		map[0][0] = "��";
		map[map.length - 1][0] = "��";
		map[0][map[0].length - 1] = "��";
		map[map.length - 1][map[0].length - 1] = "��";

	}

	// �Ʒ� �Լ����� �ϳ��� ���Ĺ���
	public void map_all(String move) {

		this.map_player_move(move);

		// ���� ��ǥ�� ������ ���Ͷ� ����
		if (player.xLoca == monster.xLoca && player.yLoca == monster.yLoca)
			player.monster_encounter();

		// if(player.xLoca == Store.)

		// ���Ͱ� ���������� �̵���Ű�� �޼ҵ� ����
		if (MonsterNum != 0)
			this.map_monster_move();

		// ���������� ����� �ؾ���
		// �ٵ� ��Ż�� ������ �� ���� ����ϴ°� �ƴ϶� ���� �ٲ㼭 ����ؾߴ�...
		// ���� ��Ż�� ������ store.map_print�� ���� �ʰ� town.map_print�� �� �� ��Ż�� ��ġ�� �÷��̾ �̵�.
		this.map_print();

	}

	// �� ����ϴ� �Լ�
	public void map_print() {

		for (int a = 0; a < 20; a++)
			System.out.println();

		// ��Ż���� �̵��Ҷ� �ѹ� ���ָ� �ɵ�
		// this.map[player.yLoca][player.xLoca] = player.art;
		// this.map[monster.yLoca][monster.xLoca] = monster.art;
		for (int down = 0; down < map.length; down++) {
			for (int side = 0; side < map[0].length; side++) {
				System.out.print(map[down][side]);
			}
			System.out.println();

		}
	}

	// �÷��̾� �̵� �޼ҵ�
	public void map_player_move(String move) {

		// �÷��̾ ���� �ִ� ��ġ�� ��ĭ���� �ʱ�ȭ
		this.map[player.yLoca][player.xLoca] = "-";

		// ��Ż ������Ʈ
		this.map[potalyLoca1][potalxLoca1] = "@";

		// wasd �Է¿� ���� �����̴� ���� �޶���
		switch (move) {
		case "w":
			player.yLoca--;
			if (player.yLoca == 0) {
				player.yLoca++;
				System.out.println("�������� �̵��� �� �����ϴ�!");
				System.out.println("�ٽ� �Է����ּ���!");
				return;
			}
			break;
		case "a":
			player.xLoca--;
			if (player.xLoca == 0) {
				player.xLoca++;
				System.out.println("�������� �̵��� �� �����ϴ�!");
				System.out.println("�ٽ� �Է����ּ���!");
				return;
			}
			break;
		case "s":
			player.yLoca++;
			if (player.yLoca == this.map.length - 1) {
				player.yLoca--;
				System.out.println("�������� �̵��� �� �����ϴ�!");
				System.out.println("�ٽ� �Է����ּ���!");
				return;
			}
			break;
		case "d":
			player.xLoca++;
			if (player.xLoca == this.map[0].length - 1) {
				player.xLoca--;
				System.out.println("�������� �̵��� �� �����ϴ�!");
				System.out.println("�ٽ� �Է����ּ���!");
				return;
			}
			break;
		default:
			System.out.println("wasd�̿��� ���� �Է��Ͽ����ϴ�.");
			System.out.println("���� ��������°� �� ���������ּ���");
			System.out.println("�ٽ� �Է����ּ���. ��...");
			return;
		}

		// �̵��� ��ǥ�� �÷��̾� ��ȣ�� ��ġ�ϵ���
		this.map[player.yLoca][player.xLoca] = player.art;

	}

	public void map_monster_move() {

		Random rand = new Random();
		int ran1, ran2;

		ran1 = rand.nextInt(2) - 1;
		ran2 = rand.nextInt(1);

		// ���Ͱ� ���� �ִ� ���� �ʱ�ȭ
		this.map[monster.yLoca][monster.xLoca] = "-";

		// ran2�� 1Ȥ�� 0�� �����. ���� 1�̸� �¿�, 0�̸� ���Ϸ� �̵�
		// ran1�� 1,0,-1�� ����� ���� ���� ��ǥ�� �����־� �¿��� ����, �̵�x, ���������� �̵���Ŵ.
		// ���� ���� �΋Hġ�� ������ �� �ݴ������� �̵���Ŵ. ���ʺ��� ������ ���������� �����̵�.
		if (ran2 == 1) {
			if (monster.xLoca == 1) {
				monster.xLoca++;
				System.out.println("���� ���� �΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else if (monster.xLoca == this.map[0].length - 2) {
				monster.xLoca--;
				System.out.println("������ ���� �΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else {
				monster.xLoca += ran1;
				System.out.println("�Ⱥ΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			}
		} else if (ran2 == 0) {
			if (monster.yLoca == 1) {
				monster.yLoca++;
				System.out.println("���� ���� �΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else if (monster.yLoca == this.map.length - 2) {
				monster.yLoca--;
				System.out.println("�Ʒ��� ���� �΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else {
				monster.yLoca += ran1;
				System.out.println("�Ⱥ΋H��");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			}
		}

		this.map[monster.yLoca][monster.xLoca] = monster.art;

	}

	// ��ŻŸ�� �� �̵� �޼ҵ�
	// public void map_move{

	// }

}
