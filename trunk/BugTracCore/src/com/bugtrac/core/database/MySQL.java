/*
  	BugTrac Open Source Bugtracking Software
    
    Copyright (C) 2012  Maximilian H.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Download and more information: code.google.com/p/bugtrac
 
 */

package com.bugtrac.core.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQL {
    private static java.sql.Connection conn = null;
 
    // Hostname
    private static String Host = null;
 
    // Port -- Standard: 3306
    private static String Port = "3306";
 
    // Datenbankname
    private static String database = null;
 
    // Datenbankuser
    private static String User = null;
 
    // Datenbankpasswort
    private static String Password = null;
	
    public MySQL(String host, String database, String username, String password)
    {
    	MySQL.Host = host;
    	MySQL.database = database;
    	MySQL.User = database;
    	MySQL.Password = password;
    }
	
    // Connects to the database and initializes the connection.
    public void connect()
    {
    	try {
    		// Loading database driver.
            Class.forName("com.mysql.jdbc.Driver");
 
            // Finally connecting to the MySQL database.
            conn = DriverManager.getConnection("jdbc:mysql://" + Host + ":"
                    + Port + "/" + database + "?" + "user=" + User + "&"
                    + "password=" + Password);
        } catch (ClassNotFoundException e) {
            System.out.println("Please check if the mysql driver for Java is available!");
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database!");
            e.printStackTrace();
        }
    }
    
    // Gets a value from the MySQL Database and returns it in a String array.
    public String[] getValue(String sql, int numRows)
    {
    	if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            Statement query;
            try {
            	String[] results = new String[numRows];
            	
                query = conn.createStatement();
 
                // Ergebnistabelle erzeugen und abholen.
                ResultSet result = query.executeQuery(sql);
 
                // Ergebnissätze durchfahren.
                while (result.next()) {
                	for (int i = 0; i < numRows; i++) {
                		results[i] = new String(result.getString(1));
                	}
                }
                
                return results;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	
    	return new String[] { "error" };
    }
    
    // Executes a SQL Statement with no response, like INSERT or UPDATE
    public Boolean executeSQL(String sql)
    {
    	if(conn != null)
        {
            // Anfrage-Statement erzeugen.
            java.sql.Statement query;
            
            try {
            	query = conn.createStatement();
 
                // Ergebnistabelle erzeugen und abholen.
                ResultSet result = query.executeQuery(sql);
 
                return true;
                
            } catch (SQLException e) {
                return false;
            }
        }
    	
    	return false;
    }
	
}
