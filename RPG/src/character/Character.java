package character;

import java.util.Random;

public class Character {

	String name;
	public int hp; // 설명필요?
	public int mp;
	public int ad; // 공격력
	public int dp; // 방어력
	public int criticalRate; // 크확
	public int avd; // 회피율
	public int damage; // 뎀지
	// public String loca[][];//맵에서의 좌표 를 2차원배열로 만들면 안됨.
	public int xLoca;
	public int yLoca;// 각각 x, y 좌표
	public String art;
	
	public int nowhp; 
	public int nowmp;

	Random rand = new Random();

	int ran;

	public Character(String name, int hp, int mp, int ad, int dp, int criticalRate, int avd, int xLoca, int yLoca,
			String art) {
		this.name = name;
		this.hp = hp;// 밸런스 조절 가즈아
		this.mp = mp;
		this.ad = ad;
		this.dp = dp;
		this.criticalRate = criticalRate;
		this.avd = avd;
		this.xLoca = xLoca;
		this.yLoca = yLoca;
		this.art = art;
		this.nowhp = hp; 
		this.nowmp = mp;
	}

	// 크리티컬 적용 메소드
	public void battle_critical() {

		ran = rand.nextInt(99) + 1;

		if (ran <= criticalRate) { // 1~100까지 난수를 받아서 크리티컬 확률보다 크면 그대로 아니면 2배 == 확률
			this.damage *= 2;
			System.out.println("크리티컬!!");
		}
	}

	// 회피 적용 메소드
	public void battle_Avoid() {

		ran = rand.nextInt(99) + 1;

		if (ran <= avd) { // 1~100까지 난수를 받아서 크리티컬 확률보다 크면 그대로 아니면 2배 == 확률
			this.damage = 0;
			System.out.println("공격 빗나감!");
			return;
		}

	}

}
