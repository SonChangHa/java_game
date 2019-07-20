package main;

import character.*;
import java.util.Scanner;
import equip_Item.*;
import map.*;
import script.Script;
import skill.*;
import use_item.*;

public class Main extends Thread {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String move;
		int select = 0;
		
		// 플레이어 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자
		Player player = new Player("김용사", 10000, 100, 30, 10, 0, 0, 1, 1, "+");
		// 플레이어는 바뀌지 않는 값이니까 스태틱 선언해도됌
		Monster.player = player;
		MyMap.player = player;
		Equip_item.player = player;
		Use_item.player = player;
		Skill.player = player;
		Script.player = player;
		Battle_thread.player = player;
		
		Script script = new Script();


		// 방어구 객체 생성(이름, hp, dp, avd)
		// 무게랑 내구도는 뺍시다
		Armor noarmor = new Armor("맨몸", 0, 0, 0);
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		//Armor  = new Armor("", , , );
		
		
		// 무기 객체 생성(이름, ad, cri)
		Weapon noweapon = new Weapon("맨손", 1, 1);
		Weapon startsword = new Weapon("시작의 검", 10, 10);

		
		
		// 몬스터 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자)
		Monster slime = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		//Monster slime = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		//Monster slime = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		//Monster slime = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0");
		
		
		//보스몬스터
		Monster rockBoss = new Monster("고벨리누스", 100, 100, 30, 5, 30, 30, 5, 1, "#");
		
		
		
		
		//NPC 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자, 타입)
		//타입이 1이면 상인 2이면 일반
		NPC elder = new NPC("이장", 10, 10, 1, 1, 1, 1, 7, 7, "!");
		NPC snow = new NPC("설화", 10, 10, 1, 1, 1, 1, 4, 3, "!");
		
		NPC elf = new NPC("요정", 1, 1, 1, 1, 1, 1, 5, 5, "!");
		

		// 포션 객체 생성(이름, 개수, 회복체력, 회복마나)
		Portion redPortion = new Portion("빨강 포션", 10, 15, 10);

		// 회복스킬 객체 생성(이름, 소모 마나, 회복 체력%, 스킬 설명)
		Heal smallHeal = new Heal("하급 회복", 5, 10, "체력을 조금 회복한다.");

		//스킬북 객체 생성(이름, 스킬)
		SkillBook lowhealbook = new SkillBook("하급회복 책", smallHeal);

		// 맵 객체 생성(new String[y길이][x길이], 이름, 포탈1 x좌표, y좌표, 포탈2 x, 포탈2 y, 포탈1 연결맵, 2 연결맵, 몹 1,2,3,4,5)
		Twopotal town = new Twopotal(new String[10][20], "마을", 6, 6, 8, 1, null, null);
		Onepotal home = new Onepotal(new String[10][10], "스윗홈", 5, 1, town);
		Onepotal nothing = new Onepotal(new String[3][3], "이동의 방", 1, 1, town);
		Onepotal pond = new Onepotal(new String[10][15], "연못", 5, 1, town);
		Twopotal rock1 = new Twopotal(new String[15][10], "바위산 1", 5, 13, 5, 1, town, null);
		Twopotal rock2 = new Twopotal(new String[15][10], "바위산 2", 5, 13, 5, 1, rock1, null);
		Onepotal rock3 = new Onepotal(new String[15][10], "바위산 3", 5, 13, rock2);
		
		rock1.potalnext2 = rock2;
		rock2.potalnext2 = rock3;
		
		
		town.potalnext1 = home;
		town.potalnext2 = nothing;
		town.npc1 = elder;
		
		
		pond.monster1 = slime;
		pond.npc1 = elf;
		
		rock3.monster1 = rockBoss;
		
		
		
		
		
		//최초맵 지정
		player.nowmap = rock2;
		
		//최초 방어구 지정
		//player.armor_inventory.add(noarmor);
		player.armor = noarmor;
		//최초 무기 지정
		//player.weapon_inventory.add(noweapon);
		player.weapon = noweapon;
		
		
		
		
		
		
		// 여기부터 게임 시작

		script.game_start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//{포탈이랑 플레이어 표시해줌
		player.nowmap.map[player.nowmap.potalyLoca1][player.nowmap.potalxLoca1] = "@";
		player.nowmap.map[player.yLoca][player.xLoca] = player.art;
		//}여기까지는 최초 한번만 해주면됨
		player.nowmap.map_print();
		
		
		Battle_thread thread = new Battle_thread();
		
		
		
		while (true) {
				
			if(player.nowmap == town)
				town.potalnext2 = nothing;
			
			if(player.nowmap == nothing) {
				System.out.println("이동하고 싶은 던전을 입력해주세요.");
				System.out.println("1 : 연못");
				System.out.println("2 : 바위산");
				select = scan.nextInt();
				
			if(select == 1) {
				town.potalnext2 = pond;
				player.nowmap = pond;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
			else if(select == 2) {
				town.potalnext2 = rock1;
				player.nowmap = rock1;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
				
			}
				
			}
			
			
			//대사
			
			//집 나가면 집 나가야지 대사가 출력되지 않게함
			if(player.nowmap != home)
				script.home_start_cheak = false;
			
			//집나가야지 대사
			if(script.home_start_cheak == true)
				script.home_start();
			
			//장로만나면 연못가라는 대사
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elder_start_cheak == true) {
				script.elder_start();
				script.elder_start_cheak = false;
				elder.art = "*";
			}
			

			if(player.nowmap == pond && player.xLoca == elf.xLoca && player.yLoca == elf.yLoca && elf.art.equals("!")) {
				System.out.println("====================================");
				System.out.println("요정 : 당신이 새로운 용사가 될 사람인가 보군요");
				System.out.println("요정 : 반갑습니다 용사여.");
				System.out.println("요정 : 이 검을 받고 당신의 운명을 수행하세요.");
				player.weapon_inventory.add(startsword);
				System.out.println("인벤토리에 시작의 검이 추가되었습니다.");
				System.out.println("요정 : 안녕히가세요 용사여. 당신의 운명에 희망이 있길 빕니다.");
				System.out.println("====================================");
				elf.art = "*";
				script.metElf = true;
			}
			
			if(player.nowmap == rock3 && thread.rockBoss_start_cheak == true) {
				thread.monster = rockBoss;
				thread.start();
				thread.rockBoss_start_cheak = false;
			}
			
			
			
			
			
			
			
			
			
			System.out.println("이동하려면 wasd, 메뉴로 들어가시려면 1을 입력해주세요.");
			move = scan.next();//자바 개새끼 진짜 Line쓰면 개행문자 머시기땜에 안되고 걍 넥스트 쓰셈
			// string은 || 같은 수식 비교가 안됨. 그래서 저런 메소드를 사용해야함.
			if (move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d"))
				player.nowmap.map_all(move);
			 else {
				player.show_menu();
				player.nowmap.map_print();
			 }
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// 메인메소드

}
