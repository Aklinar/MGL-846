import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import main.java.Employee.conn;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.add_employee;
import main.java.Employee.testableConn;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ST_1_01Test {
	
	public static add_employee page;
	public static ActionEvent ae;

	public static conn mySqlConn = new conn();
	public static String name = "John";
	public static String fathersName = "Wick";
	public static String age = "30";
	public static String birthDate = "1995/03/24";
	public static String address = "32 rue de la grange";
	public static String phone = "0666007666";
	public static String email = "johnattan@mail.com";
	public static String education = "graduate";
	public static String jobPost = "mercenary";
	public static String aadharNo = "666666666";
	public static String employeeId = "1002";

	@BeforeClass
	public static void setUp()
	{
		page = new add_employee();
		ae = new ActionEvent(page.getB1(), 1001, "Submit");
		
		page.getT1().setText(name);
		page.getT2().setText(fathersName);
		page.getT3().setText(age);
		page.getT4().setText(birthDate);
		page.getT5().setText(address);
		page.getT6().setText(phone);
		page.getT7().setText(email);
		page.getT8().setText(education);
		page.getT9().setText(jobPost);
		page.getT10().setText(aadharNo);
		page.getT11().setText(employeeId);
	}

	@After
	public void deleteEmployee() {
		String deleteQuery = "DELETE FROM employee WHERE emp_id = '" + employeeId + "'";
		try {
			mySqlConn.st.execute(deleteQuery);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	
    @Test
    public void CT_1_01_1() 
    {
		try
		{
			page.actionPerformed(ae, true);
		} finally {
			String select_employee_query = "select * from employee where emp_id = '" + employeeId + "'";
			ResultSet rs = null;
			boolean is_found = false;
			try {
				rs = mySqlConn.st.executeQuery(select_employee_query);
				while (rs.next()) {
					is_found = true;
					assertEquals(rs.getString("name"), name);
					assertEquals(rs.getString("fname"), fathersName);
					assertEquals(rs.getString("age"), age);
					assertEquals(rs.getString("dob"), birthDate);
					assertEquals(rs.getString("address"), address);
					assertEquals(rs.getString("phone"), phone);
					assertEquals(rs.getString("email"), email);
					assertEquals(rs.getString("education"), education);
					assertEquals(rs.getString("post"), jobPost);
					assertEquals(rs.getString("aadhar"), aadharNo);
				}
				assertEquals(true, is_found);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
    }    

    @Test
    public void CT_1_02_1() throws Exception
    {
		page.getT3().setText("erreur");
		page.getT6().setText("erreur");
		page.getT10().setText("erreur");
		page.getT11().setText("erreur");
    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_03_1() throws Exception
    {
		page.getT1().setText("66666");
		page.getT2().setText("66666");
		page.getT8().setText("66666");
		page.getT9().setText("66666");
		
    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_04_1() throws Exception
    {
		page.getT1().setText("***");
		page.getT2().setText("***");
		page.getT3().setText("***");
		page.getT4().setText("***");
		page.getT5().setText("***");
		page.getT6().setText("***");
		page.getT8().setText("***");
		page.getT9().setText("***");
		page.getT10().setText("***");
		page.getT11().setText("***");

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   
    

    @Test
    public void CT_1_05_1() throws Exception
    {
		page.getT1().setText("");
		page.getT2().setText("");
		page.getT3().setText("");
		page.getT4().setText("");
		page.getT5().setText("");
		page.getT6().setText("");
		page.getT8().setText("");
		page.getT9().setText("");
		page.getT10().setText("");
		page.getT11().setText("");

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_06_1() throws Exception
    {
		page.getT7().setText("@@@");
		

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

    @Test
    public void CT_1_07_1() throws Exception
    {
		page.getT11().setText("1000");
		

    	boolean test = false;
    	
		try
		{
			page.actionPerformed(ae, true);
		}
		catch(Exception e)
		{
			test = true;
		}
		assertTrue(test);
    }   

}
