package com.memory.services;

import java.io.File;

import com.memory.pojo.Values;

public class MakeDirectory implements IServices{
	
	private Values val=null;
	
	public MakeDirectory(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		try{
			new File(val.getCurrDir()+"/"+val.getParameter()).mkdirs();
		}catch(Exception e){
			return "could not create directory";
		}
		return "directory is created";
	}

}
