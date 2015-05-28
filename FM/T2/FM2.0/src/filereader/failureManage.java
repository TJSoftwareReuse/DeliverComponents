/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filereader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Levy
 */
public class failureManage {
    
    /**
     *
     * @param e
     * @throws IOException
     */
    public static void outputFailure(Exception e) throws IOException{
        failureManage.outputFailure(e,"failureLog.txt");
    }

    /**
     *
     * @param e
     * @param filePath
     * @throws IOException
     */
    public static void outputFailure(Exception e,String filePath) throws IOException{
        Date date=new Date();
        FileWriter fw=new FileWriter(filePath,true);
        fw.write(e.toString()+"\r\n");
        fw.write(date.toString()+"\r\n\r\n");
        fw.close();
        
    }
    

}
