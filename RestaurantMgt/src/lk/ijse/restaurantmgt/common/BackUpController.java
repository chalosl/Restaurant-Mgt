/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.restaurantmgt.common;

import java.io.IOException;
import org.omg.SendingContext.RunTime;

/**
 *
 * @author CHALO
 */
public class BackUpController {
    public static int wrigthBackUp(String path) throws IOException, InterruptedException{
        Runtime runtime = Runtime.getRuntime();
        Process runPro = runtime.exec("mysqldump restaurantmgt -h localhost -u root -p 1234 -r"+path);
        int res=runPro.waitFor();
        return res;    
    }
    
}
