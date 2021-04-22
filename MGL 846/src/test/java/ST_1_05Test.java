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
import main.java.Employee.search_employee;
import main.java.Employee.testableConn;

public class ST_1_05Test {
	
	public static search_employee page;
	public static ActionEvent aeSearch;
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
		page = new search_employee();
		
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
    public void CT_1_14() 
    {
    	page.getT().setText("9999");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    }    

	
    @Test
    public void CT_1_15()
    {
    	page.getT().setText("9999");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    }   

	
    @Test
    public void CT_1_16()
    {
    	page.getT().setText("erreur");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    } 

	
    @Test
    public void CT_1_17()
    {
    	page.getT().setText("***");
		
    	//Il s'avère qu'il n'existe pas de fonctionalité de recherche, voir la note du rapport
    	
    	assertFalse(true);
    } 

}
