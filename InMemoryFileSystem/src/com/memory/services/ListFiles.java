package com.memory.services;

import java.io.File;
import java.util.Date;

import com.memory.pojo.Values;

public class ListFiles implements IServices{
	
private Values val=null;
	
	public ListFiles(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		File directory = new File(val.getCurrDir());
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName()+" - "+file.length()/1000+"kb - "+(file.canRead()?"Read":" ")+(file.canWrite()?"Write":" ")+" - "+new Date(file.lastModified() * 1000));
        }
		return "are files available in "+val.getCurrDir();
	}
	
}
