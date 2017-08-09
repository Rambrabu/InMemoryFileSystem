package com.memory.services;

import com.memory.pojo.Values;

public class PrintDirectory implements IServices{
	
private Values val=null;
	
	public PrintDirectory(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		
		return val.getCurrDir();
	}
	
}
