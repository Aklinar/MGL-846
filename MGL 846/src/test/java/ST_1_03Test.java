package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.update_employee;
import main.java.Employee.conn;
import main.java.Employee.testableConn;

public class ST_1_03Test {
	
	public static update_employee page;
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
	public static String employeeId = "9999";
	
	@BeforeClass
	public static void setUp()
	{
		

		String add_employee_query = "insert into employee values('"
				+ name + "','"
				+ fathersName + "','"
				+ age + "','"
				+ birthDate + "','"
				+ address + "','"
				+ phone + "','"
				+ email + "','"
				+ education + "','"
				+ jobPost + "','"
				+ aadharNo + "','"
				+ employeeId + "')";

		try {
			mySqlConn.st.execute(add_employee_query);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		page = new update_employee("9999");
		ae = new ActionEvent(page.getB(), 1001, "Submit");
		
		page.getT1().setText("John2");
		page.getT2().setText("Wick2");
		//page.getT3().setText("30");
		//page.getT4().setText("1995/03/24");
		page.getT3().setText("32 rue de la grange2");
		page.getT4().setText("06660076662");
		page.getT5().setText("johnattan@mail.com2");
		page.getT6().setText("graduate2");
		page.getT7().setText("mercenary2");
		page.getT8().setText("6666666662");
		page.getT9().setText("99992");
		
	}
	
	@AfterClass
	public static void tearDown()
	{
		String deleteQuery = "DELETE FROM employee WHERE emp_id = '9999'";
		try {
			mySqlConn.st.execute(deleteQuery);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		String deleteQuery2 = "DELETE FROM employee WHERE emp_id = '99992'";
		try {
			mySqlConn.st.execute(deleteQuery2);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		String deleteQuery3 = "DELETE FROM employee WHERE emp_id = ''";
		try {
			mySqlConn.st.execute(deleteQuery3);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	
    @Test
    public void CT_1_01_2() 
    {
    	page.actionPerformed(ae, true);
    	
		String select_employee_query = "select * from employee where emp_id = '" + employeeId + "2'";
		ResultSet rs = null;
		boolean is_found = false;
		try {
			rs = mySqlConn.st.executeQuery(select_employee_query);
			while (rs.next()) {
				is_found = true;
				assertEquals(name + "2", rs.getString("name"));
				assertEquals(fathersName + "2", rs.getString("fname"));
//				assertEquals(rs.getString("age"), age);
//				assertEquals(rs.getString("dob"), birthDate);
				assertEquals(address + "2", rs.getString("address"));
				assertEquals(phone + "2",rs.getString("phone"));
				assertEquals(email + "2", rs.getString("email"));
				assertEquals(education + "2", rs.getString("education"));
				assertEquals(jobPost + "2", rs.getString("post"));
				assertEquals(aadharNo + "2", rs.getString("aadhar"));
			}
			assertEquals(true, is_found);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
    }    

    @Test
    public void CT_1_02_2() throws Exception
    {
		page.getT4().setText("erreur");
		page.getT8().setText("erreur");
		page.getT9().setText("erreur");
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
    public void CT_1_03_2() throws Exception
    {
		page.getT1().setText("66666");
		page.getT2().setText("66666");
		page.getT6().setText("66666");
		page.getT7().setText("66666");
		
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
    public void CT_1_04_2() throws Exception
    {
		page.getT1().setText("***");
		page.getT2().setText("***");
		page.getT3().setText("***");
		page.getT4().setText("***");
		page.getT6().setText("***");
		page.getT7().setText("***");
		page.getT8().setText("***");
		page.getT9().setText("***");

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
    public void CT_1_05_2() throws Exception
    {
		page.getT1().setText("");
		page.getT2().setText("");
		page.getT3().setText("");
		page.getT4().setText("");
		page.getT6().setText("");
		page.getT7().setText("");
		page.getT8().setText("");
		page.getT9().setText("");

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
    public void CT_1_06_2() throws Exception
    {
		page.getT5().setText("@@@");
		

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
    public void CT_1_07_2() throws Exception
    {
		page.getT9().setText("1000");
		

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
