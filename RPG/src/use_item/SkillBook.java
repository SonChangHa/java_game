package use_item;

import skill.Heal;
import skill.Skill;

public class SkillBook extends Use_item {

	public Skill skill;
	
	public SkillBook(String name, Skill skill) {
		super(name);
		this.skill = skill;
	}
	
	public static void use_skillbook(SkillBook skillbook) {
		if(skillbook.skill.toString().equals("Heal")) 
			player.healskill_list.add((Heal)skillbook.skill);
		
		//이제 여기다가 다른 스킬들도 넣어야함
		
		System.out.println("다음 스킬이 등록되었습니다.");
		System.out.println(skillbook.skill.name);
		
	}
}
