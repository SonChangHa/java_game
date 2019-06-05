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

		Store store = new Store(new String[10][20], 3, 3, town);// [x좌표][y좌표]

		// 플레이어 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자
		Player player = new Player("자바를 하는 창하", 50, 10, 10, 10, 10, 10, 1, 2, "+");
		player.nowmap = store;
		//플레이어는 바뀌지 않는 값이니까 스태틱 선언해도됌
		Monster.player = player;
		MyMap.player = player;

		// 방어구 객체 생성 (이름, 개수, 내구도, hp, dp, avd)
		Armor armor1 = new Armor("문혁이 형의 과제에도 굴하지 않는 강철멘탈", 1, 1, 1, 1, 1);

		// 몬스터 객체 생성
		Monster ork = new Monster("자바 과제를 내준 문혁이형", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		
		store.monster1 = ork;

		System.out.println("게임 시작 가즈아ㅏㅏㅏㅏㅏㅏ");

		player.nowmap = store;
		while (true) {
			move = scan.nextLine();
			player.nowmap.map_all(move);
		}

	}// 메인메소드

}
