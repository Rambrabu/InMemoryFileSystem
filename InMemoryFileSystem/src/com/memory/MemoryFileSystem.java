package com.memory;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import com.memory.pojo.Values;
import com.memory.services.ChangeDirectory;
import com.memory.services.CopyFile;
import com.memory.services.IServices;
import com.memory.services.InValidCommands;
import com.memory.services.ListFiles;
import com.memory.services.MakeDirectory;
import com.memory.services.MoveFile;
import com.memory.services.PrintDirectory;
import com.memory.services.RemoveDirectory;
import com.memory.test.MemoryFileSystemTest;
import com.memory.utilities.Commands;
import com.memory.utilities.Utility;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MemoryFileSystem {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		String cmd = null;
		IServices services = null;
		Values values = new Values();
		values.setCurrDir(IServices.ROOTDIRECTORY);
		
		//Junit test runs here
		runJunitTest();
		
	    //getting input from user
		Scanner scanner = new Scanner(System.in);
		do{
			cmd = scanner.nextLine();
			
			//ENUM is used here, since string for switch statement is available from java 1.7
			Commands command = Utility.getCommand(cmd.toUpperCase());
			String param = Utility.getParamForDir(cmd);
			values.setParameter(param);
			
			switch(command){
				case MKDIR:
					services = new MakeDirectory(values);
					break;
				
				case CD:
					services = new ChangeDirectory(values);
					break;
				
				case RM:
					services = new RemoveDirectory(values);
					break;
				
				case LS:
					services = new ListFiles(values);
					break;
				
				case CP:
					String cptoDir = Utility.getToDir(cmd);
					values.setToDir(values.getCurrDir()+"/"+cptoDir);
					values.setParameter(values.getCurrDir()+"/"+values.getParameter());
					services = new CopyFile(values);
					break;
					
				case MV:
					String mvtoDir = Utility.getToDir(cmd);
					values.setToDir(values.getCurrDir()+"/"+mvtoDir);
					values.setParameter(values.getCurrDir()+"/"+values.getParameter());
					services = new MoveFile(values);
					break;
				
				case PWD:
					services = new PrintDirectory(values);
					break;
				
				case INVALID:
					services = new InValidCommands();
					break;
				
				default:
					services = new InValidCommands();
			}
			
			System.out.println(services.Operations());
			
		}
		while (!"exit".equalsIgnoreCase(cmd));
		scanner.close();
		latch.countDown();
	}
	
	static void runJunitTest(){
		Result result = JUnitCore.runClasses(MemoryFileSystemTest.class);
		
	    for (Failure failure : result.getFailures()) {
	        System.out.println(failure.toString());
	    }
			
	    System.out.println("Junit test runs "+(result.wasSuccessful()?"successfully":" with failure"));
	}
	
	

}
