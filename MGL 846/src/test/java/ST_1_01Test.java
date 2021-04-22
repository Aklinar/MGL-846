package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.add_employee;
import main.java.Employee.conn;
import main.java.Employee.testableConn;

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
	public static String employeeId = "9999";
	
	@BeforeClass
	public static void setUp()
	{
		page = new add_employee();
		ae = new ActionEvent(page.getB1(), 1001, "Submit");
		
		page.getT1().setText("John");
		page.getT2().setText("Wick");
		page.getT3().setText("30");
		page.getT4().setText("1995/03/24");
		page.getT5().setText("32 rue de la grange");
		page.getT6().setText("0666007666");
		page.getT7().setText("johnattan@mail.com");
		page.getT8().setText("graduate");
		page.getT9().setText("mercenary");
		page.getT10().setText("666666666");
		page.getT11().setText("9999");
	}
	
	@After
	public void deleteEmployee()
	{
		String deleteQuery = "DELETE FROM employee WHERE emp_id = '" + employeeId + "'";
		try {
			mySqlConn.st.execute(deleteQuery);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown()
	{
		String deleteQuery = "DELETE FROM employee WHERE emp_id = '***'";
		try {
			mySqlConn.st.execute(deleteQuery);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		String deleteQuery2 = "DELETE FROM employee WHERE emp_id = 'erreur'";
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
					assertEquals(name, rs.getString("name"));
					assertEquals(fathersName, rs.getString("fname"));
					assertEquals(age, rs.getString("age"));
					assertEquals(birthDate, rs.getString("dob"));
					assertEquals(address, rs.getString("address"));
					assertEquals(phone, rs.getString("phone"));
					assertEquals(email, rs.getString("email"));
					assertEquals(education, rs.getString("education"));
					assertEquals(jobPost, rs.getString("post"));
					assertEquals(aadharNo, rs.getString("aadhar"));
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
