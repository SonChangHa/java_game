package map;

import character.*;
import java.util.Random;

public class MyMap {

	public static String[][] map;
	public static Player player;
	public static Monster monster;
	public static int MonsterNum;// 필드에 남아있는 몬스터의 수
	public int potalxLoca1;
	public int potalyLoca1;
	public int potalxLoca2;
	public int potalyLoca2;

	public MyMap(String map[][]) {
		this.map = map;

		// 이하 코드들은 맵의 틀을 만드는 코드
		for (int down = 0; down < map.length; down++) {
			for (int side = 0; side < map[0].length; side++) {
				map[down][side] = "-";
			}
		}

		for (int down = 0; down < map.length; down++) {
			map[down][0] = "│";
			map[down][map[0].length - 1] = "│";
		}

		for (int side = 0; side < map[0].length; side++) {
			map[0][side] = "─";
			map[map.length - 1][side] = "─";
		}

		map[0][0] = "┏";
		map[map.length - 1][0] = "┗";
		map[0][map[0].length - 1] = "┓";
		map[map.length - 1][map[0].length - 1] = "┛";

	}

	// 아래 함수들을 하나로 합쳐벌임
	public void map_all(String move) {

		this.map_player_move(move);

		// 만약 좌표가 같으면 몬스터랑 만남
		if (player.xLoca == monster.xLoca && player.yLoca == monster.yLoca)
			player.monster_encounter();

		// if(player.xLoca == Store.)

		// 몬스터가 남아있으면 이동시키는 메소드 동작
		if (MonsterNum != 0)
			this.map_monster_move();

		// 움직였으면 출력을 해야제
		// 근데 포탈에 닿으면 이 맵을 출력하는게 아니라 맵을 바꿔서 출력해야댐...
		// 만약 포탈에 닿으면 store.map_print를 하지 않고 town.map_print를 한 후 포탈의 위치로 플레이어를 이동.
		this.map_print();

	}

	// 맵 출력하는 함수
	public void map_print() {

		for (int a = 0; a < 20; a++)
			System.out.println();

		// 포탈에서 이동할때 한번 해주면 될듯
		// this.map[player.yLoca][player.xLoca] = player.art;
		// this.map[monster.yLoca][monster.xLoca] = monster.art;
		for (int down = 0; down < map.length; down++) {
			for (int side = 0; side < map[0].length; side++) {
				System.out.print(map[down][side]);
			}
			System.out.println();

		}
	}

	// 플레이어 이동 메소드
	public void map_player_move(String move) {

		// 플레이어가 원래 있던 위치를 빈칸으로 초기화
		this.map[player.yLoca][player.xLoca] = "-";

		// 포탈 오브젝트
		this.map[potalyLoca1][potalxLoca1] = "@";

		// wasd 입력에 따라 움직이는 것이 달라짐
		switch (move) {
		case "w":
			player.yLoca--;
			if (player.yLoca == 0) {
				player.yLoca++;
				System.out.println("그쪽으론 이동할 수 없습니다!");
				System.out.println("다시 입력해주세요!");
				return;
			}
			break;
		case "a":
			player.xLoca--;
			if (player.xLoca == 0) {
				player.xLoca++;
				System.out.println("그쪽으론 이동할 수 없습니다!");
				System.out.println("다시 입력해주세요!");
				return;
			}
			break;
		case "s":
			player.yLoca++;
			if (player.yLoca == this.map.length - 1) {
				player.yLoca--;
				System.out.println("그쪽으론 이동할 수 없습니다!");
				System.out.println("다시 입력해주세요!");
				return;
			}
			break;
		case "d":
			player.xLoca++;
			if (player.xLoca == this.map[0].length - 1) {
				player.xLoca--;
				System.out.println("그쪽으론 이동할 수 없습니다!");
				System.out.println("다시 입력해주세요!");
				return;
			}
			break;
		default:
			System.out.println("wasd이외의 것을 입력하였습니다.");
			System.out.println("제발 하지말라는거 좀 하지말아주세요");
			System.out.println("다시 입력해주세요. 후...");
			return;
		}

		// 이동한 좌표에 플레이어 기호가 위치하도록
		this.map[player.yLoca][player.xLoca] = player.art;

	}

	public void map_monster_move() {

		Random rand = new Random();
		int ran1, ran2;

		ran1 = rand.nextInt(2) - 1;
		ran2 = rand.nextInt(1);

		// 몬스터가 원래 있던 곳을 초기화
		this.map[monster.yLoca][monster.xLoca] = "-";

		// ran2는 1혹은 0을 출력함. 만약 1이면 좌우, 0이면 상하로 이동
		// ran1은 1,0,-1을 출력함 따라서 기존 좌표에 더해주어 좌우라면 왼쪽, 이동x, 오른쪽으로 이동시킴.
		// 만약 벽에 부딫치면 강제로 그 반대쪽으로 이동시킴. 왼쪽벽에 박으면 오른쪽으로 강제이동.
		if (ran2 == 1) {
			if (monster.xLoca == 1) {
				monster.xLoca++;
				System.out.println("왼쪽 벽에 부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else if (monster.xLoca == this.map[0].length - 2) {
				monster.xLoca--;
				System.out.println("오른쪽 벽에 부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else {
				monster.xLoca += ran1;
				System.out.println("안부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			}
		} else if (ran2 == 0) {
			if (monster.yLoca == 1) {
				monster.yLoca++;
				System.out.println("위쪽 벽에 부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else if (monster.yLoca == this.map.length - 2) {
				monster.yLoca--;
				System.out.println("아래쪽 벽에 부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			} else {
				monster.yLoca += ran1;
				System.out.println("안부딫힘");
				System.out.println(monster.xLoca);
				System.out.println(monster.yLoca);
				System.out.println(ran1);
				System.out.println(ran2);
			}
		}

		this.map[monster.yLoca][monster.xLoca] = monster.art;

	}

	// 포탈타고 맵 이동 메소드
	// public void map_move{

	// }

}
