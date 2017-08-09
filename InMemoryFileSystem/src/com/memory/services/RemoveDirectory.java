package com.memory.services;

import java.io.File;

import com.memory.pojo.Values;

public class RemoveDirectory implements IServices{
	
private Values val=null;
	
	public RemoveDirectory(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		return deleteDir(new  File(val.getCurrDir()+"/"+val.getParameter()))?"The directory is deleted":"The directory is not deleted completely";
	}
	
	public static boolean deleteDir(File dir) {
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir (new File(dir, children[i]));
	            
	            if (!success) {
	               return false;
	            }
	         }
	      }
	      return dir.delete();
	   }
	
}
