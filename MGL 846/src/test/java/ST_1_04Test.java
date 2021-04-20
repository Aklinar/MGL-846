package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

//import org.junit.Before;
import org.junit.Test;

import main.java.Employee.add_employee;
import main.java.Employee.conn;
import main.java.Employee.print_data;
import main.java.Employee.remove_employee;
import main.java.Employee.testableConn;

public class ST_1_04Test {
	
	public static print_data page;
	public static ActionEvent aeSearch;
	public static ActionEvent aeDelete;
	public static boolean switcher = true;
	
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
	}
	
    @Test
    public void CT_1_10() 
    {
		page = new print_data("9999");
		
		assertEquals("9999", page.getEmp_id());
		assertEquals("John", page.getName());
		assertEquals("Wick", page.getFather());
		assertEquals("32 rue de la grange", page.getAddress());
		assertEquals("0666007666", page.getPhone());
		assertEquals("johnattan@mail.com", page.getEmail());
		assertEquals("graduate", page.getEducation());
		assertEquals("mercenary", page.getPost());
    }    


	@After
	public void tearDown()
	{
		if (switcher) {
			String deleteQuery = "DELETE FROM employee WHERE emp_id = '9999'";
			try {
				mySqlConn.st.execute(deleteQuery);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		switcher = false;
	}
	
    @Test
    public void CT_1_11()
    {
		page = new print_data("9999");

		assertFalse(page.getFlag());
    }   

	
    @Test
    public void CT_1_12()
    {
		page = new print_data("erreur");

		assertFalse(page.getFlag());
    } 

	
    @Test
    public void CT_1_13()
    {
		page = new print_data("***");

		assertFalse(page.getFlag());
    } 

}
