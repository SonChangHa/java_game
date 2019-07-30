package skill;

import character.Player;

public class Skill {
	
	public static Player player;
	public String name;
	public int useMp;
	public String what;
	
	public Skill(String name, int useMp, String what) {
		this.name = name;
		this.useMp = useMp;
		this.what = what;
	}
	
	
	
}