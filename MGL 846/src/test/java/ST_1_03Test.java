import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import Employee.conn;
import org.junit.Assert;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import Employee.update_employee;
import Employee.testableConn;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
	public static String employeeId = "1002";
	
	@BeforeClass
	public static void setUp()
	{
		page = new update_employee("1000");
		ae = new ActionEvent(page.getB(), 1001, "Submit");

		page.getT1().setText(name);
		page.getT2().setText(fathersName);
		//page.getT3().setText(age);
		//page.getT4().setText(birthDate);
		page.getT3().setText(address);
		page.getT4().setText(phone);
		page.getT5().setText(email);
		page.getT6().setText(education);
		page.getT7().setText(jobPost);
		page.getT8().setText(aadharNo);
		page.getT9().setText(employeeId);

	}
	
    @Test
    public void CT_1_01_2() 
    {
		String select_employee_query = "select * from employee where emp_id = '" + employeeId + "'";
		ResultSet rs = null;
		boolean is_found = false;
		try {
			rs = mySqlConn.st.executeQuery(select_employee_query);
			while (rs.next()) {
				is_found = true;
				assertEquals(rs.getString("name"), name);
				assertEquals(rs.getString("fname"), fathersName);
//				assertEquals(rs.getString("age"), age);
//				assertEquals(rs.getString("dob"), birthDate);
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
