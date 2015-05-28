package filereader;
import java.util.Date;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;



public class TestFailureManager {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


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
	@Test(timeout = 1000)
	public void testoutputFailure() throws IOException {
		System.out.println("test outputFailure");
		Exception e = null;
		Date date=new Date();
		String mylog = "";
		String filePath="myFailureLog.txt";
		failureManage instance = new failureManage();
   
        String expResult = e.toString() + date.toString();
        instance.outputFailure(e, "myFailureLog.txt");
        
        List list = readLastNLine(new File("log.out"),10L);
        String result = (String) list.get(list.size()-1);
        
        assertEquals(expResult==result,1);
        }
	
    @Test(timeout = 1000)
    public void testlogInfo() throws IOException{
    	System.out.println("test log4jFailureManager");
    	String mystring = "aoaoao";
    	String filePath = "";
    	
    }
    
}
