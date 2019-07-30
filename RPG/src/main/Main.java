package main;

import character.*;
import java.util.Scanner;

import battleThread.CastleBattleThread;
import battleThread.PorestBattleThread;
import battleThread.RockBattleThread;
import equip_Item.*;
import map.*;
import music.*;
import script.Script;
import skill.*;
import use_item.*;

public class Main extends Thread {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String move;
		int select = 0;
		
		// 플레이어 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자
		Player player = new Player("김용사", 10000, 100, 200, 10, 0, 0, 1, 1, "+");
		// 플레이어는 바뀌지 않는 값이니까 스태틱 선언해도됌
		Monster.player = player;
		MyMap.player = player;
		Equip_item.player = player;
		Use_item.player = player;
		Skill.player = player;
		Script.player = player;
		RockBattleThread.player = player;
		PorestBattleThread.player = player;
		CastleBattleThread.player = player;
		NPC.player = player;
		SwordSkill.player = player;
		Weapon.player = player;
		
		Script script = new Script();

		// 무기스킬 (이름 소모 데미지 설명)
		SwordSkill noskill = new SwordSkill("때리기", 10, 50, "개쌔게 때린다.");
		SwordSkill startskill = new SwordSkill("시작의 공격", 30, 100, "시작의 공격을 한다.");
		SwordSkill goblinskill = new SwordSkill("두번찌르기", 50, 150, "두번 찌른다.");
		SwordSkill orkskill = new SwordSkill("아머브레이크", 100, 300, "방어구를 부수며 공격한다.");
		SwordSkill vampireskill = new SwordSkill("핏빛베기", 300, 500, "핏빛으로 벤다");

		// 방어구 객체 생성(이름, 가격, hp, dp, avd)
		// 무게랑 내구도는 뺍시다
		Armor noarmor = new Armor("맨몸", 0, 0, 0, 0);
		Armor startarmor = new Armor("모험가의 옷", 0, 100, 10, 10);
		Armor goblinarmor = new Armor("도적 복면", 1000, 50, 10, 80);
		Armor orkarmor = new Armor("월장석 갑옷", 3000, 300, 50, 0);
		Armor vampirearmor = new Armor("고위 제복", 5000, 200, 30, 50);
		
		
		// 무기 객체 생성(이름, 가격, ad, cri, 스킬)
		Weapon noweapon = new Weapon("맨손", 0, 1, 1, noskill);
		Weapon startsword = new Weapon("시작의 검", 0, 10, 10, startskill);
		Weapon goblinsword = new Weapon("고블린 단검", 1000, 20, 80, goblinskill);
		Weapon orksword = new Weapon("오크제 대검", 3000, 70, 0, orkskill);
		Weapon vampiresword = new Weapon("흡혈검", 5000, 40, 50, vampireskill);
		

		
		
		// 몬스터 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자, 경험치, 골드)
		Monster slime1 = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime2 = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime3 = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		Monster slime4 = new Monster("슬라임", 30, 10, 20, 10, 10, 10, 3, 5, "0", 20, 50);
		
		
		//보스몬스터
		Monster rockBoss = new Monster("고벨리누스", 100, 100, 30, 5, 30, 30, 5, 1, "#", 100, 300);
		Monster porestBoss = new Monster("오르쿠스", 300, 300, 30, 60, 40, 40, 13, 13, "#", 300, 500);
		Monster castleBoss = new Monster("하트언더블레이드", 600, 500, 100, 50, 30, 30, 18, 5, "#", 600, 100);
		
		
		
		
		//NPC 객체 생성(이름, hp, mp, ad, dp, cri, avd, x좌표, y좌표, 표시문자)
		//타입이 1이면 상인 2이면 일반
		NPC elder = new NPC("이장", 10, 10, 1, 1, 1, 1, 7, 7, "!");
		NPC snow = new NPC("설화", 10, 10, 1, 1, 1, 1, 4, 3, "!");
		NPC merchant = new NPC("상인아조씨", 10, 10, 1, 1, 1, 1, 2, 2, "$");
		
		NPC elf = new NPC("요정", 1, 1, 1, 1, 1, 1, 5, 5, "!");
		
		merchant.npc_armor_inventory.add(goblinarmor);
		merchant.npc_armor_inventory.add(orkarmor);
		merchant.npc_armor_inventory.add(vampirearmor);
		
		merchant.npc_weapon_inventory.add(goblinsword);
		merchant.npc_weapon_inventory.add(orksword);
		merchant.npc_weapon_inventory.add(vampiresword);
		
		

		// 포션 객체 생성(이름, 가격, 개수, 회복체력, 회복마나)
		Portion redPortion = new Portion("빨강 포션", 10, 1, 30, 0);
		Portion bluePortion = new Portion("파란 포션", 10, 1, 0, 30);
		Portion allPortion = new Portion("보라 포션", 30, 1, 30, 30);
		
		merchant.npc_portion_inventory.add(redPortion);
		merchant.npc_portion_inventory.add(bluePortion);
		merchant.npc_portion_inventory.add(allPortion);

		// 회복스킬 객체 생성(이름, 소모 마나, 회복 체력%, 스킬 설명)
		Heal lowHeal = new Heal("하급 회복", 5, 10, "체력을 조금 회복한다.");
		Heal middleHeal = new Heal("중급 회복", 30, 50, "체력을 적당히 회복한다.");
		Heal bigHeal = new Heal("고급 회복", 100, 70, "체력을 많이 회복한다.");

		//스킬북 객체 생성(이름, 가격, 스킬)
		SkillBook lowhealbook = new SkillBook("하급회복 책", 50, lowHeal);
		SkillBook middlehealbook = new SkillBook("하급회복 책", 3000, middleHeal);
		SkillBook bighealbook = new SkillBook("하급회복 책", 5000, bigHeal);

		merchant.npc_skillBook_inventory.add(lowhealbook);
		merchant.npc_skillBook_inventory.add(middlehealbook);
		merchant.npc_skillBook_inventory.add(bighealbook);
		
		// 맵 객체 생성(new String[y길이][x길이], 이름, 포탈1 x좌표, y좌표, 포탈2 x, 포탈2 y, 포탈1 연결맵, 2 연결맵, 몹 1,2,3,4,5)
		Twopotal town = new Twopotal(new String[10][20], "마을", 6, 6, 8, 1, null, null);
		Onepotal home = new Onepotal(new String[10][10], "스윗홈", 5, 1, town);
		Onepotal nothing = new Onepotal(new String[3][3], "이동의 방", 1, 1, town);
		Onepotal pond = new Onepotal(new String[10][15], "연못", 5, 1, town);
		Twopotal rock1 = new Twopotal(new String[15][10], "바위산 1", 5, 13, 5, 1, town, null);
		Twopotal rock2 = new Twopotal(new String[15][10], "바위산 2", 5, 13, 5, 1, rock1, null);
		Onepotal rock3 = new Onepotal(new String[15][10], "바위산 3", 5, 13, rock2);
		Twopotal porest1 = new Twopotal(new String[15][20], "천상숲 깊은곳 1", 3, 1, 13, 13, town, null);
		Twopotal porest2 = new Twopotal(new String[15][20], "천상숲 깊은곳 2", 3, 1, 13, 13, porest1, null);
		Onepotal porest3 = new Onepotal(new String[15][20], "천상숲 깊은곳 3", 3, 1, porest2);
		Twopotal castle1 = new Twopotal(new String[10][20], "흡혈귀 성 1", 1, 5, 18, 5, town, null);
		Twopotal castle2 = new Twopotal(new String[10][20], "흡혈귀 성 2", 1, 5, 18, 5, castle1, null);
		Onepotal castle3 = new Onepotal(new String[10][20], "흡혈귀 성 3", 1, 5, castle2);
		
		
		rock1.potalnext2 = rock2;
		rock2.potalnext2 = rock3;
		
		porest1.potalnext2 = porest2;
		porest2.potalnext2 = porest3;
		
		castle1.potalnext2 = castle2;
		castle2.potalnext2 = castle3;
		
		town.potalnext1 = home;
		town.potalnext2 = nothing;
		town.npc1 = elder;
		town.npc2 = snow;
		town.npc3 = merchant;
		
		rock1.monster1 = slime1;
		rock2.monster1 = slime4;
		porest2.monster1 = slime2;
		castle2.monster1 = slime3;
		pond.npc1 = elf;
		
		rock3.monster1 = rockBoss;
		porest3.monster1 = porestBoss;
		castle3.monster1 = castleBoss;
		
		
		
		
		//최초맵 지정
		player.nowmap = home;
		
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
		
		
		RockBattleThread rockThread = new RockBattleThread();
		PorestBattleThread porestThread = new PorestBattleThread();
		CastleBattleThread castleThread = new CastleBattleThread();
		TimeThread time = new TimeThread();
		MusicThread music = new MusicThread();
		BattleMusic battlemusic = new BattleMusic();
		CastleMusic castlemusic = new CastleMusic();
		PorestMusic porestmusic = new PorestMusic();
		RockMusic rockmusic = new RockMusic();
		
		
		time.start();
		music.start();
		battlemusic.start();
		castlemusic.start();
		porestmusic.start();
		rockmusic.start();
		
		//music.suspend();
		battlemusic.suspend();
		castlemusic.suspend();
		porestmusic.suspend();
		rockmusic.suspend();
		
		//player.battle = battlemusic;
		player.castle = castlemusic;
		player.porest = porestmusic;
		player.rock = rockmusic;
		player.music = music;
		
		//리팩토링 개꿀팁 : 어차피 현재맵, 좌표가 같아야하는건 동일하니까 그건 한 if로 묶고 그 아래 if를 더 넣으셈 개꿀 ㅇㅈ? ㅇㅇㅈ
		while (true) {
			
			if(TimeThread.day.equals("낮")) {
				castleBoss.art = "┏";
				castleBoss.xLoca = 0;
				castleBoss.yLoca = 0;
			} else {
				castleBoss.art = "#";
				castleBoss.xLoca = 18;
				castleBoss.yLoca = 5;
			}
			
			if(player.nowmap == town) {
				castlemusic.suspend();
				porestmusic.suspend();
				rockmusic.suspend();
				music.resume();
			}
			else if(player.nowmap == rock1 || player.nowmap == rock2 || player.nowmap == rock3) {
			//	castlemusic.suspend();
			//	porestmusic.suspend();
				music.suspend();
				rockmusic.resume();
			}
			else if(player.nowmap == porest1 || player.nowmap == porest2 || player.nowmap == porest3) {
			//	castlemusic.suspend();
				porestmusic.resume();
				music.suspend();
			//	rockmusic.suspend();
			}
			else if(player.nowmap == castle1 || player.nowmap == castle2 || player.nowmap == castle3) {
				castlemusic.resume();
			//	porestmusic.suspend();
				music.suspend();
			//	rockmusic.suspend();
			}
			
			//아무것도 없을때 대사
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && elder.art.equals("*"))
				script.nothingElder();
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && snow.art.equals("*"))
				script.nothingSnow();
			
			//페이즈를 클리어하면 이전것이 나오지 않도록함.
			//연못다녀오면 끝
			if(Script.clearPond) {
				script.home_start_cheak = false;
				script.elder_start_cheak = false;
				script.snowStartCheck = false;
				elder.art = "!";
				snow.art = "!";
				script.elderPhase2 = true;
				script.snowPhase2 = true;
				Script.clearPond = false;
				//바위산 다녀옴
			} else if (Script.clearRock) {
				script.elderPhase2 = false;
				script.snowPhase2 = false;
				elder.art = "!";
				snow.art = "!";
				script.elderPhase3 = true;
				script.snowPhase3 = true;
				Script.clearRock = false;
				//성 다녀옴
			} else if(Script.clearporest) {
				script.elderPhase3 = false;
				script.snowPhase3 = false;
				elder.art = "!";
				snow.xLoca = 0;
				snow.yLoca = 0;
				snow.art = "┏";
				script.elderPhase4 = true;
				Script.clearporest = false;
			}
			
				
			if(player.nowmap == town)
				town.potalnext2 = nothing;
			
			if(player.nowmap == nothing) {
				System.out.println("이동하고 싶은 던전을 입력해주세요.");
				System.out.println("1 : 연못");
				System.out.println("2 : 바위산");
				System.out.println("3 : 천상숲");
				System.out.println("4 : 카르타피아 산맥");
				System.out.println("이외의 것을 선택하면 돌아갑니다.");
				select = scan.nextInt();
				
			if(select == 1) {
				town.potalnext2 = pond;
				player.nowmap = pond;
				pond.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
			else if(select == 2) {
				town.potalnext2 = rock1;
				player.nowmap = rock1;
				rock1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
				
			}else if(select == 3) {
				town.potalnext2 = porest1;
				player.nowmap = porest1;
				porest1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}else if(select == 4) {
				TimeThread.time = 0;
				TimeThread.day = "밤";
				town.potalnext2 = castle1;
				player.nowmap = castle1;
				castle1.potalnext1 = town;

				player.xLoca = player.nowmap.potalxLoca1;
				player.yLoca = player.nowmap.potalyLoca1;

				player.nowmap.map[player.yLoca][player.xLoca] = player.art;
				player.nowmap.map_print();
			}
				
			}
			
			if(player.nowmap == town && player.xLoca == merchant.xLoca && player.yLoca == merchant.yLoca) {
				merchant.metStore();
			}
			//대사
			
			//집 나가면 집 나가야지 대사가 출력되지 않게함
			if(player.nowmap != home)
				script.home_start_cheak = false;
			
			//집나가야지 대사
			if(script.home_start_cheak == true)
				script.home_start();
			//시작할때 설화 대사
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowStartCheck == true) {
				script.snowStart();
				script.snowStartCheck = false;
				snow.art = "*";
			}
			
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
				System.out.println("요정 : 안녕히가세요 용사여. 당신의 운명에 희망이 있길 빕니다.");
				System.out.println("====================================");
				System.out.println("인벤토리에 시작의 검이 추가되었습니다.");
				System.out.println("");
				elf.art = "*";
				Script.clearPond = true;
			}
			
			if(player.nowmap == rock3 && rockThread.rockBoss_start_cheak == true) {
				rockThread.monster = rockBoss;
				rockThread.start();
				rockThread.rockBoss_start_cheak = false;
			}
			
			if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowPhase2 == true) {
				script.wentToPond();
				script.snowPhase2 = false;
				snow.art = "*";
				player.armor_inventory.add(startarmor);
			}
			
			if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase2 == true) {
				script.goToRock();
				script.elderPhase2 = false;
				elder.art = "*";
			}
			
		if(RockBattleThread.rockThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			RockBattleThread.rockThreadEnd = false;
		}
		
		if(PorestBattleThread.porestThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			PorestBattleThread.porestThreadEnd = false;
		}
		
		if(CastleBattleThread.castleThreadEnd == true) {
			player.nowmap = town;
			player.xLoca = player.nowmap.potalxLoca1;
			player.yLoca = player.nowmap.potalyLoca1;

			player.nowmap.map[player.yLoca][player.xLoca] = player.art;
			player.nowmap.map_print();
			CastleBattleThread.castleThreadEnd = false;
		}
			
		if(player.nowmap == porest3 && porestThread.porestBoss_start_cheak == true) {
			porestThread.monster = porestBoss;
			porestThread.start();
			porestThread.porestBoss_start_cheak = false;
		}
		
		if(player.nowmap == town && player.xLoca == snow.xLoca && player.yLoca == snow.yLoca && script.snowPhase3 == true) {
			script.wentToRock();
			script.snowPhase3 = false;
			snow.art = "*";
		}
		
		if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase3 == true) {
			script.goToPorest();
			script.elderPhase3 = false;
			elder.art = "*";
		}
		
		if(player.nowmap == town && player.xLoca == elder.xLoca && player.yLoca == elder.yLoca && script.elderPhase4 == true) {
			script.goToCastle();
			script.elderPhase4 = false;
			elder.art = "*";
		}
		
		if(player.nowmap == castle3 && castleThread.castleBoss_start_cheak == true) {
			castleThread.monster = castleBoss;
			castleThread.start();
			castleThread.castleBoss_start_cheak = false;
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
