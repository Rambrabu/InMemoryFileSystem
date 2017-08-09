package com.memory.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class MemoryFileSystemTest {

   @Test
   public void testPrintMessage() {
	  File f = new  File("resource/root");
      assertEquals("Success", true, f.isDirectory());
   }
   
   public void printMessage(){
	   System.out.println("Junit test in runs");
   }
}