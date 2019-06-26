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
		
		//���� ����ٰ� �ٸ� ��ų�鵵 �־����
		
		System.out.println("���� ��ų�� ��ϵǾ����ϴ�.");
		System.out.println(skillbook.skill.name);
		
	}
}
