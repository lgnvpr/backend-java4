/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luongnvpk.helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import Config.Config;

/**
 *
 * @author ADMIN
 */
public class ConnectSQL {
    Connection conn;

    public ConnectSQL() throws ClassNotFoundException {
        connect();
    }

    public void connect() throws ClassNotFoundException {
    	System.out.println("on connect...");
        try {
//            String DBSQL = "jdbc:sqlserver://localhost:1433;databaseName=" + DataBaseName + ";user=" + user + ";password=" + Pass + "";
        	Class.forName("com.mysql.jdbc.Driver");
        	conn = DriverManager.getConnection( "jdbc:"+Config.getCofig().dbUrlConnection(), "root","vanluong@123" );
        	System.out.println("connected");
            resultConnect = true;
        } catch (SQLException ex) {
            resultConnect = false;
            System.out.println("connect fail");
            System.out.println(ex);
//            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean resultConnect = true;

    public PreparedStatement preparedStatement(String sql, Object... ob) {
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            for (int i = 0; i < ob.length; i++) {
                ps.setObject(i + 1, ob[i]);
            }

            return ps;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet resultSet(String sql, Object... ob) {
        try {

            ResultSet rs = preparedStatement(sql, ob).executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean executeUpdate(String sql, Object... ob) {
        PreparedStatement Statement = preparedStatement(sql, ob);
        try {
            Statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
