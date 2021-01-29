package Migration;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import luongnvpk.helper.ConnectSQL;
import luongnvpk.helper.ObjectHelper;

public class migration {
	public void migraion() {
		String pathComputer = "/home/lgnvpr/Documents/Fpoly/java-4/lab/abc/src/Migration/";
		ConnectSQL conn = null;
		File currentDirFile = new File(".");
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		String helper = currentDirFile.getAbsolutePath();
		System.out.println(helper);
		ArrayList<String> saved = new ArrayList<String>();
		try {
			conn = new ConnectSQL();
			conn.executeUpdate("CREATE TABLE IF NOT EXISTS check_save(name varchar(225) not null)");
			ResultSet rs = conn.resultSet("select * from check_save");
			try {
				while(rs.next()) {
					saved.add(rs.getString("name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        File folder = new File(pathComputer+ "table/");
        

        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
            	File fileData = new File(pathComputer.concat("table/").concat(file.getName()));
            	int checkExit = saved.indexOf(file.getName());
                if(fileData.isFile() && checkExit<0){
                	String sql = "";
                    Scanner scan = null;
                    try {
                        scan = new Scanner(fileData); 
                        while(scan.hasNextLine()){
                        	sql += String.valueOf(scan.nextLine());
                        }         
                    } catch (Exception e) {
                    }
                   
                    if(conn.executeUpdate(sql)) {
                    	System.out.println("succes-----".concat(file.getName()));  
                    	conn.executeUpdate("insert into check_save values(?)",  file.getName());
                    }
                    else {
                    	System.out.println("fail-----".concat(file.getName()));
                    	
                    }
                }
            }
        }
        
        File folder2 = new File(pathComputer+ "seeDb/");
        File[] listOfFiles2 = folder2.listFiles();
        for (File file : listOfFiles2) {
        	System.out.println( "-----"+ file.getName());
            if (file.isFile()) {
            	File fileData = new File(pathComputer.concat("seeDb/").concat(file.getName()));
            	int checkExit = saved.indexOf(file.getName());
                if(fileData.isFile() && checkExit<0){
                	String sql = "";
                    Scanner scan = null;
                    try {
                        scan = new Scanner(fileData); 
                        while(scan.hasNextLine()){
                        	sql += String.valueOf(scan.nextLine());
                        }         
                    } catch (Exception e) {
                    }
                    
                   
                    if(conn.executeUpdate(sql)) {
                    	System.out.println("succes-----".concat(file.getName()));  
                    	conn.executeUpdate("insert into check_save values(?)",  file.getName());
                    }
                    else {
                    	System.out.println("fail-----".concat(file.getName()));
                    	
                    }
                }
            }
        }
        
        
	}
	
	
	
}
