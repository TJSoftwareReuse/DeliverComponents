package Main;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class FM {
	private String strFileName;
	
	public void setLogFile(String strFileName) {
		this.strFileName = strFileName;
	}
	public String getLogFile()
	{
		return strFileName;
	}
	public boolean warn(int nID, String strInfomation) {	
	    try {
			File file = new File(this.strFileName);
			if(!file.exists())
				file.createNewFile();
				
			FileOutputStream out = new FileOutputStream(file,true);
			StringBuffer sb = new StringBuffer();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sb.append(sdf.format(new Date()));
			sb.append("  ");
			sb.append("ID : " + nID);
			sb.append("  ");
			sb.append("Infomation : " + strInfomation);
			sb.append("\r\n");
			out.write(sb.toString().getBytes("utf-8"));
			out.close();
			return true;
		} catch(IOException ex) {
            System.out.println(ex.getStackTrace());
            return false;
        }		
	}
}
