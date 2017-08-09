package com.memory.services;

public class InValidCommands implements IServices {

	@Override
	public String Operations() {
		return "invalid command, Available command inputs are mkdir, cd, rm, ls, cp,mv, pwd";
	}

}
