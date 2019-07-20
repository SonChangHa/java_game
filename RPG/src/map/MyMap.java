package map;

import character.*;
import java.util.Random;

public class MyMap {

	public String[][] map; // �̰� �ù� ����ƽ���� �����ϱ� �ȹٲ��� ��ģ�ʸ�
	public static Player player;
	public Monster monster1;
	public Monster monster2;
	public Monster monster3;
	public Monster monster4;
	public Monster monster5;
	public NPC npc1;
	public NPC npc2;
	public NPC npc3;
	public NPC npc4;
	public NPC npc5;
	public int potalxLoca1;
	public int potalyLoca1;
	public int potalxLoca2;
	public int potalyLoca2;

	public MyMap potalnext1;
	public MyMap potalnext2;

	public String name;

	public MyMap(String map[][], String name) {
		this.map = map;
		this.name = name;

		// ���� �ڵ���� ���� Ʋ�� ����� �ڵ�
		for (int down = 0; down < this.map.length; down++) {
			for (int side = 0; side < this.map[0].length; side++) {
				this.map[down][side] = "-";
			}
		}

		for (int down = 0; down < this.map.length; down++) {
			this.map[down][0] = "��";
			this.map[down][this.map[0].length - 1] = "��";
		}

		for (int side = 0; side < this.map[0].length; side++) {
			this.map[0][side] = "��";
			this.map[this.map.length - 1][side] = "��";
		}

		this.map[0][0] = "��";
		this.map[this.map.length - 1][0] = "��";
		this.map[0][this.map[0].length - 1] = "��";
		this.map[this.map.length - 1][this.map[0].length - 1] = "��";

	}

	// �Ʒ� �Լ����� �ϳ��� ���Ĺ���
	public void map_all(String move) {

		this.map_player_move(move);

		if (player.nowmap.potalnext1 != null)
			player.nowmap.map[potalyLoca1][potalxLoca1] = "@";
		if (player.nowmap.potalnext2 != null)
			player.nowmap.map[potalyLoca2][potalxLoca2] = "@";

		// ���Ͱ� ���������� �̵���Ű�� �޼ҵ� ����
				// �ٵ� �ٷξƷ��� ���� ���?
		
		if (monster1 != null) {
			if (player.xLoca == monster1.xLoca && player.yLoca == monster1.yLoca)
				player.monster_encounter(monster1);
		}

		if (monster2 != null) {
			if (player.xLoca == monster2.xLoca && player.yLoca == monster2.yLoca)
				player.monster_encounter(monster2);
		}

		if (monster3 != null) {
			if (player.xLoca == monster3.xLoca && player.yLoca == monster3.yLoca)
				player.monster_encounter(monster3);
		}

		if (monster4 != null) {
			if (player.xLoca == monster4.xLoca && player.yLoca == monster4.yLoca)
				player.monster_encounter(monster4);
		}

		if (monster5 != null) {
			if (player.xLoca == monster5.xLoca && player.yLoca == monster5.yLoca)
				player.monster_encounter(monster5);
		}
		
				if (monster1 != null && monster1.art.equals("0"))
					this.map_monster_move(monster1);
				if (monster2 != null && monster2.art.equals("0"))
					this.map_monster_move(monster2);
				if (monster3 != null && monster3.art.equals("0"))
					this.map_monster_move(monster3);
				if (monster4 != null && monster4.art.equals("0"))
					this.map_monster_move(monster4);
				if (monster5 != null && monster5.art.equals("0"))
					this.map_monster_move(monster5);
		
		// ���� ��ǥ�� ������ ���Ͷ� ����
		// �ù��̰ԸӾ�


		if (player.xLoca == this.potalxLoca1 && player.yLoca == this.potalyLoca1) {
			//���� ��ġ�� ���� ���� ��Ż�� 1�� ������ 2�� �����ĸ� ���ؾ���
			if (player.nowmap == this.potalnext1.potalnext1) {
				player.nowmap = this.potalnext1;

				
				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art; // �÷��̾� ���
			}

			if (player.nowmap == this.potalnext1.potalnext2) {
				player.nowmap = this.potalnext1;

				// �̰� �ƴ� �̷������� �Ǹ� ��Ż �̵��ص� �̵��Ѱ��� �̻��ϰԳ���
				player.xLoca = player.nowmap.potalxLoca2;
				player.yLoca = player.nowmap.potalyLoca2;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art; // �÷��̾� ���
			}

		}

		
		
		if (player.xLoca == this.potalxLoca2 && player.yLoca == this.potalyLoca2) {
			if (player.nowmap == this.potalnext2.potalnext1) {
				player.nowmap = this.potalnext2;

				
				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art; // �÷��̾� ���
			}

			if (player.nowmap == this.potalnext2.potalnext2) {
				player.nowmap = this.potalnext2;

				// �̰� �ƴ� �̷������� �Ǹ� ��Ż �̵��ص� �̵��Ѱ��� �̻��ϰԳ���
				player.xLoca = player.nowmap.potalxLoca2;
				player.yLoca = player.nowmap.potalyLoca2;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art; // �÷��̾� ���
			}

		}

		this.map_print();

	}

	// �� ����ϴ� �Լ�
	public void map_print() {

		for (int a = 0; a < 50; a++)
			System.out.println();

		System.out.println(player.nowmap.name);
		for (int down = 0; down < player.nowmap.map.length; down++) {
			for (int side = 0; side < player.nowmap.map[0].length; side++) {
				System.out.print(player.nowmap.map[down][side]);
			}
			System.out.println();

		}
	}

	// �÷��̾� �̵� �޼ҵ�
	public void map_player_move(String move) {

		// �÷��̾ ���� �ִ� ��ġ�� ��ĭ���� �ʱ�ȭ
		this.map[player.yLoca][player.xLoca] = "-";

		if (monster1 != null)
			this.map[monster1.yLoca][monster1.xLoca] = monster1.art;// �� 1
		if (monster2 != null)
			this.map[monster2.yLoca][monster2.xLoca] = monster2.art;
		if (monster3 != null)
			this.map[monster3.yLoca][monster3.xLoca] = monster3.art;
		if (monster4 != null)
			this.map[monster4.yLoca][monster4.xLoca] = monster4.art;
		if (monster5 != null)
			this.map[monster5.yLoca][monster5.xLoca] = monster5.art;// �� 5

		if (npc1 != null)
			this.map[npc1.yLoca][npc1.xLoca] = npc1.art;
		if (npc2 != null)
			this.map[npc2.yLoca][npc2.xLoca] = npc2.art;
		if (npc3 != null)
			this.map[npc3.yLoca][npc3.xLoca] = npc3.art;
		if (npc4 != null)
			this.map[npc4.yLoca][npc4.xLoca] = npc4.art;
		if (npc5 != null)
			this.map[npc5.yLoca][npc5.xLoca] = npc5.art;

		// wasd �Է¿� ���� �����̴� ���� �޶���
		switch (move) {
		case "w":
			player.yLoca--;
			if (player.yLoca == 0)
				player.yLoca++;
			break;
		case "a":
			player.xLoca--;
			if (player.xLoca == 0)
				player.xLoca++;
			break;
		case "s":
			player.yLoca++;
			if (player.yLoca == player.nowmap.map.length - 1)
				player.yLoca--;
			break;
		case "d":
			player.xLoca++;
			if (player.xLoca == player.nowmap.map[0].length - 1)
				player.xLoca--;
			break;
		}

		// �̵��� ��ǥ�� �÷��̾� ��ȣ�� ��ġ�ϵ���
		player.nowmap.map[player.yLoca][player.xLoca] = player.art;

	}

	public void map_monster_move(Monster monster) {

		Random rand = new Random();
		int ran1, ran2;

		ran1 = rand.nextInt(2) - 1;
		ran2 = rand.nextInt(1);

		// ���Ͱ� ���� �ִ� ���� �ʱ�ȭ
		player.nowmap.map[monster.yLoca][monster.xLoca] = "-";

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
			} else if (monster.xLoca == player.nowmap.map[0].length - 2) {
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
			} else if (monster.yLoca == player.nowmap.map.length - 2) {
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

		player.nowmap.map[monster.yLoca][monster.xLoca] = monster.art;

	}

}
