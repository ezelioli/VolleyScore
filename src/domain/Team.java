package domain;

import java.util.List;

public class Team {
	private String name;
	private Coach headCoach;
	private Coach assistantCoach;
	
	public Team(String name){
		this.name = name;
	}

	public Team(String name, Coach headCoach, Coach assistantCoach) {
		this.name = name;
		this.headCoach = headCoach;
		this.assistantCoach = assistantCoach;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coach getHeadCoach() {
		return headCoach;
	}

	public Coach getAssistantCoach() {
		return assistantCoach;
	}
}
