package com.memory.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.memory.pojo.Values;

public class CopyFile implements IServices{
	
private Values val=null;
	
	public CopyFile(Values values){
		val = values;
	}

	@Override
	public String Operations() {
		File source = new File(val.getParameter());
		File dest = new File(val.getToDir());
		try {
			return copyFile(source, dest)?"The File is copied":"File is not copied";
		} catch (IOException e) {
			return "File is not copied";
		}
	}
	
	protected static boolean copyFile(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } catch(Exception e){
	    	return false;
	    }finally {
	        is.close();
	        os.close();
	    }
		return true;
	}
	
}
