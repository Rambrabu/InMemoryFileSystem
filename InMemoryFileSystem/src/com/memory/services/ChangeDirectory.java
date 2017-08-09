package com.memory.services;

import java.io.File;

import com.memory.pojo.Values;

public class ChangeDirectory implements IServices {
	
	private Values val=null;
	
	public ChangeDirectory(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		
		if(val.getParameter()!=null && val.getParameter().equals("..")){
			
			val.setCurrDir(onelevelUp(val.getCurrDir()));
			
		}else if(val.getParameter()!=null && val.getParameter().equals("../../")){
			
			val.setCurrDir(twolevelUp(val.getCurrDir()));
			
		}else {
			
			if(!new File(val.getCurrDir()+"/"+val.getParameter()).exists())
				return "invalid directory";
			
			val.setCurrDir(val.getCurrDir()+"/"+val.getParameter());
		}
		
		return val.getCurrDir();
	}
	
	static String onelevelUp(String dir){
		String [] path = dir.split("/");
		
		if(path.length<=2)
			return ROOTDIRECTORY;
		
		String currdir = levelUp(path,1);
		return currdir;
	}
	
	static String twolevelUp(String dir){
		String [] path = dir.split("/");
		
		if(path.length<=2)
			return ROOTDIRECTORY;
		
		String currdir = levelUp(path,2);
		return currdir;
	}
	
	static String levelUp(String [] path, int level){
		StringBuilder  currDir = new StringBuilder();
		
		for(int i=0;i<path.length-level;i++){
			if (i < 1)
				currDir.append(path[0]);
			else
				currDir.append("/").append(path[i]);
		}
		return  currDir.toString();
	}
	
	

}
