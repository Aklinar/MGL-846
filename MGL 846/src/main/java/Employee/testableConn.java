package main.java.Employee;

/*
CLASS Creation Steps:
1.conn
2.welcome_page
3.login_page
4.details_page
5.add_employee
6.view_employee
7.print_data
8.remove_employee
9.search_employee
10.update_employee

*/

import java.sql.*;

public class testableConn {

	//Create two interface
	public Connection c;  // used to set up connection with mysql
	public Statement st;  // used to execute all queries of mysql
	public String exceptionResult;
	
	public testableConn(String url, String user, String psswrd) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load mysql jdbc driver
			c = DriverManager.getConnection(url,user,psswrd);
			st = c.createStatement(); // helpful to execute query
		} catch(Exception e) {
			exceptionResult = e.getMessage();
		}
	}

	public String getExceptionResult() {
		return exceptionResult;
	}
	
	
}
