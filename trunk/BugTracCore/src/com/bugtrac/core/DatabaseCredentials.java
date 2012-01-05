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

public class DatabaseCredentials {
	private String host;
	private String database;
	private String password;
	private String username;
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public DatabaseCredentials(String host, String database, String username, String password)
	{
		this.host = host;
		this.database = database;
		this.password = password;
		this.username = username;
	}

}
