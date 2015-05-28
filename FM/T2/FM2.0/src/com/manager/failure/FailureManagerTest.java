package com.manager.failure;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import filereader.failureManage;

public class FailureManagerTest {

	@Before
	public void setUp() throws Exception {
	}
	
	public static List<String> readLastNLine(File file,long numRead)
    {
    	List<String> result = new ArrayList<String>();
    	long count =0;
    	
    	 if (!file.exists() || file.isDirectory() || !file.canRead()){
    		 return null;
    		 }
    	 RandomAccessFile fileRead = null;
    	 try
    	 {
    		 fileRead = new RandomAccessFile(file,"r");
    		 long length = fileRead.length();
    		 if(length == 0L)
    		 {
    			 return result;
    		 }
    		 else
    		 {
    			 long pos = length -1;
    			 while(pos > 0)
    			 {
    				 pos--;
    				 fileRead.seek(pos);
    				 if(fileRead.readByte() == '\n')
    				 {
    					 String line = fileRead.readLine();
    					 result.add(line);
    					 System.out.println(line);
    					 count++;
    					 if(count == numRead)
    					 {
    						 break;
    					 }
    				 }
    			 }
    			 if(pos == 0)
    			 {
    				 fileRead.seek(0);
    				 result.add(fileRead.readLine());
    			 }
    		 }
    	 }
    	 catch(IOException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 finally
    	 {
    		 if(fileRead != null)
    		 {
    			 try
    			 {
    				 fileRead.close();
    			 }
    			 catch(Exception e)
    			 {  				 
    			 }
    		 }
    	 }
    	 return result;
    }
	

	@Test
	public void testLogInfo() {
		System.out.println("test LogInfo()\n");
		Date date=new Date();
		String mylog = "here is a info";
		String expResult = date.toString()+"INFO"+mylog;
        FailureManager instance = new FailureManager();
        instance.logDebug(mylog);       
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        assertEquals(expResult==result,1);
	}

	@Test
	public void testLogDebug() {
		System.out.println("test LogDebug()\n");
		Date date=new Date();
		String mylog = "here is a debug";
		String expResult = date.toString()+"DEBUG"+mylog;
        FailureManager instance = new FailureManager();
        instance.logDebug(mylog);       
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        assertEquals(expResult==result,1);
        }
	

	@Test
	public void testLogWarn() {
		System.out.println("test LogWarn()\n");
		Date date=new Date();
		String mylog = "here is a warning";
		String expResult = date.toString()+"WARN"+mylog;
        FailureManager instance = new FailureManager();
        instance.logDebug(mylog);       
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        assertEquals(expResult==result,1);
	}

	@Test
	public void testLogError() {
		System.out.println("test LogError()\n");
		Date date=new Date();
		String mylog = "here is an error";
		String expResult = date.toString()+"ERROR"+mylog;
        FailureManager instance = new FailureManager();
        instance.logDebug(mylog);       
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        assertEquals(expResult==result,1);
	}

	@Test
	public void testLogFatal() {
		System.out.println("test LogFatal()\n");
		Date date=new Date();
		String mylog = "here is a fatal";
		String expResult = date.toString()+"FATAL"+mylog;
        FailureManager instance = new FailureManager();
        instance.logDebug(mylog);       
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        assertEquals(expResult==result,1);	
        }

	@Test
	public void testResetOutputFile() {
		fail("Not yet implemented");
	}

}
