package com.memory.utilities;

import com.memory.utilities.Commands;

public class Utility {
	
	public static Commands getCommand (String s){
		Commands commands = null;
		if(s!=null && s.trim().length()==0)
			commands = Commands.valueOf("INVALID");
		String command = s.split(" ")[0];
		try{
			commands = Commands.valueOf(command.toUpperCase());
		}catch(IllegalArgumentException e){
			commands = Commands.valueOf("INVALID");	
		}
		return commands;
	}
	
	public static String getParamForDir (String s){
		if(s!=null && s.trim().length()==0)
			return null;
		String param = s.contains(" ")?s.split(" ")[1]:null;
			return param;
	}
	
	public static String getToDir (String s){
		if(s!=null && s.trim().length()==0)
			return null;
		String todir = s.contains(" ")&&s.split(" ").length>2?s.split(" ")[2]:null;
		todir = todir.indexOf("/")==1?todir.substring(1, todir.length()):todir;
		return todir;
	}
	
}
