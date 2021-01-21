package Migration;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import luongnvpk.helper.ConnectSQL;

public class migration {
	public void migraion() throws ClassNotFoundException {
		ConnectSQL conn =  new ConnectSQL();
//		File file = new File("../table/20012020000000_account_role.sql");
		// /home/lgnvpr/Documents/ALE_TEAM/ticket/base-ticket/README.md
		FileInputStream fin = null;
        BufferedInputStream bin = null;
 
        File folder = new File("/");

        File[] listOfFiles = folder.listFiles();
         
        for (File file : listOfFiles) {
//        	System.out.println(file.getAbsolutePath());
//            if (file.isFile()) {
//                System.out.println(file.getName());
//            }
        }
        
//        File fileData = new File("");
//        System.out.println(fileData.getParent());
//        if(fileData.isFile()){
//        	System.out.println("is file");
//            Scanner scan = null;
//            try {
//                scan = new Scanner(fileData); 
//                while(scan.hasNextLine()){
//                	System.out.println(String.valueOf(scan.nextLine()));
//                }         
//            } catch (Exception e) {
//            }
//        }
        
	}
	
	
	
}
