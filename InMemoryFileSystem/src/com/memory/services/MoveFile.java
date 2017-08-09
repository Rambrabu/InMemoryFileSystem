package com.memory.services;

import java.io.File;
import java.io.IOException;

import com.memory.pojo.Values;

public class MoveFile extends CopyFile implements IServices{
	
	private Values val=null;

	public MoveFile(Values values){
		super(values);
		val = values;
	}

	@Override
	public String Operations() {
		File source = new File(val.getParameter());
		File dest = new File(val.getToDir());
		try {
			boolean result = copyFile(source, dest)?source.delete():false;
			return result?"file is moved":"file is not moved";
			
		} catch (IOException e) {
			return "file is not Moved";
		}
	}
}
