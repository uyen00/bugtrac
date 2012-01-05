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

package com.bugtrac.core;

import java.io.Console;

public class Program {
	static DatabaseAccess dba = null;
	
	public static void main(String[] args) {
		dba = new DatabaseAccess(DatabaseType.MySQL, new DatabaseCredentials("localhost", "bugtrac", "root", ""));
		
		Console cons = System.console();
		
		argsParser(args);
		
		String cmd = null;
		String[] cmds = null;
		
		while ((cmd = cons.readLine()) != "break")
		{
			cmds = cmd.split(" ");
			String[] cmdsf = new String[cmds.length + 1];
			
			System.arraycopy(cmds, 0, cmdsf, 1, cmds.length);
			
			cmdsf[0] = new String("");
			
			argsParser(cmds);
		}
		
	}
	
	public static void argsParser(String[] args)
	{
		try
		{
			if (args[1] == "update")
			{
				dba.executeSQL(args[2]);
			}
			else if (args[1] == "get")
			{
				dba.getValue(args[2], Integer.parseInt(args[3]));
			}
		}
		catch (Exception e) { e.printStackTrace(); }
	}

}
